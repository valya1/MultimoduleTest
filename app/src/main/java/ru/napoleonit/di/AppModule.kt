package ru.napoleonit.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.napoleonit.featureCloser.FeatureCloserImpl
import ru.napoleonit.settings.dependency.FeatureCloser
import javax.inject.Singleton

@Module
interface AppModule {

    @Singleton
    @Binds
    fun featureCLoser(featureCloserImpl: FeatureCloserImpl): FeatureCloser

}
