package ru.napoleonit.di

import dagger.Module
import dagger.Provides
import ru.napoleonit.common.presentation.LocalCiceronesHolder
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Named
import javax.inject.Singleton

@Module
class NavigationModule {

    @Provides
    @Singleton
    fun cicerone(): Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    @Named("global")
    fun provideGlobalRouter(cicerone: Cicerone<Router>): Router = cicerone.router

    @Provides
    @Singleton
    fun provideLocalCiceroneHolder(): LocalCiceronesHolder = LocalCiceronesHolder()

}
