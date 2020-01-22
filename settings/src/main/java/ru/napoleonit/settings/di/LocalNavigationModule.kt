package ru.napoleonit.settings.di

import dagger.Module
import dagger.Provides
import ru.napoleonit.common.di.ActivityScope
import ru.napoleonit.common.navigation.router.TransitionsRouter
import ru.napoleonit.settings.ui.KittensContainerFragment
import ru.terrakok.cicerone.Router

@Module
class LocalNavigationModule {

    @Provides
    @ActivityScope
    fun router(settingsContainer: KittensContainerFragment): TransitionsRouter =
        settingsContainer.router

}
