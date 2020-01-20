package ru.napoleonit.settings.di

import androidx.fragment.app.Fragment
import dagger.Component
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.AndroidSupportInjectionModule
import ru.napoleonit.network.api.NetworkServiceApi
import ru.napoleonit.settings.api.ScreenFeatureApi
import ru.napoleonit.settings.dependency.FeatureCloser
import ru.napoleonit.settings.dependency.FeatureCloserDependency
import ru.napoleonit.settings.dependency.SettingsDependencies


//@Component(
//    modules = [SettingsModule::class, AndroidSupportInjectionModule::class]
//    dependencies = [SettingsDependencies::class]
//)
//interface SettingsComponent : ScreenFeatureApi, AndroidInjector<Fragment> {

//    @Component(dependencies = [NetworkServiceApi::class, FeatureCloserDependency::class])
//    interface SettingsDependenciesComponent : SettingsDependencies

//}