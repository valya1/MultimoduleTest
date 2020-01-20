package ru.napoleonit.multimoduletests.featuresInjector

import androidx.fragment.app.Fragment
import ru.napoleonit.settings.ui.SettingsContainerFragment
//import ru.napoleonit.settings.di.DaggerSettingsComponent
//import ru.napoleonit.settings.di.DaggerSettingsComponent_SettingsDependenciesComponent
import ru.terrakok.cicerone.android.support.SupportAppScreen

object FeaturesProxy {
    //
    fun startSettingsFeature(): SupportAppScreen {
        return object : SupportAppScreen() {
            override fun getFragment(): Fragment =
                SettingsContainerFragment()
        }
//        return DaggerSettingsComponent.builder()
//            .settingsDependencies(
//                DaggerSettingsComponent_SettingsDependenciesComponent.builder()
//                    .networkServiceApi(networkComponent)
////                    .featureCloserDependency(appComponent)
//                    .build()
//            )
//            .build()
//            .getScreen()
    }
}