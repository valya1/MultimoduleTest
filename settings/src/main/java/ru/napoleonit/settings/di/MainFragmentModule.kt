package ru.napoleonit.settings.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.napoleonit.common.di.FragmentScope
import ru.napoleonit.settings.ui.KittenDetailFragment
import ru.napoleonit.settings.ui.KittensFragment

@Module
abstract class MainFragmentModule {

    @ContributesAndroidInjector
    @FragmentScope
    abstract fun mainFragmentInjector(): KittensFragment

    @ContributesAndroidInjector
    @FragmentScope
    abstract fun kittensDetailInjector(): KittenDetailFragment

}
