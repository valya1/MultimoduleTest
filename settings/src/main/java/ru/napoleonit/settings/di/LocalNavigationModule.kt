package ru.napoleonit.settings.di

import dagger.Module
import dagger.Provides
import ru.napoleonit.common.di.ActivityScope
import ru.napoleonit.settings.ui.SettingsContainerFragment
import ru.terrakok.cicerone.Router

@Module
class LocalNavigationModule {

    @Provides
    @ActivityScope
    fun router(settingsContainer: SettingsContainerFragment): Router = settingsContainer.router

}
