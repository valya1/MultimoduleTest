package ru.napoleonit.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.napoleonit.common.di.ActivityScope
import ru.napoleonit.multimoduletests.RootActivity
import ru.napoleonit.settings.di.LocalNavigationModule
import ru.napoleonit.settings.di.MainFragmentModule
import ru.napoleonit.settings.ui.SettingsContainerFragment

@Module
abstract class FeaturesUIBindingModule {

    @ContributesAndroidInjector(modules = [MainFragmentModule::class, LocalNavigationModule::class])
    @ActivityScope
    abstract fun settingsInjector(): SettingsContainerFragment

    @ContributesAndroidInjector
    @ActivityScope
    abstract fun rootActivity(): RootActivity

}
