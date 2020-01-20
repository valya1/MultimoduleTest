package ru.napoleonit.network.di

import dagger.Component
import ru.napoleonit.network.api.NetworkServiceApi
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface NetworkComponent : NetworkServiceApi {

    companion object {
        val networkComponent: NetworkServiceApi by lazy {
            DaggerNetworkComponent.builder()
                .build()
        }
    }

}