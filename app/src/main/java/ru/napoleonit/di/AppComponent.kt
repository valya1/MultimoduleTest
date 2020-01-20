package ru.napoleonit.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import ru.napoleonit.BaseApplication
import ru.napoleonit.network.api.NetworkServiceApi
import ru.napoleonit.network.di.NetworkComponent.Companion.networkComponent
import javax.inject.Singleton

@Component(
    dependencies = [NetworkServiceApi::class],
    modules = [
        NavigationModule::class,
        AppModule::class,
        FeaturesUIBindingModule::class,
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class
    ]
)
@Singleton
interface AppComponent {

    fun inject(app: BaseApplication)

    companion object {
        val appComponent: AppComponent by lazy {
            DaggerAppComponent.builder()
                .networkServiceApi(networkComponent)
                .build()
        }
    }

}