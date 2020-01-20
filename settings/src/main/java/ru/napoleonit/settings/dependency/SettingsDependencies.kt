package ru.napoleonit.settings.dependency

import ru.napoleonit.network.service.ApiService
import javax.inject.Inject

class SettingsDependencies @Inject constructor(
    val apiService: ApiService,
    val featureCloser: FeatureCloser
) {

//    fun apiService(): ApiService
//
//    fun closeFeature(): FeatureCloser
}