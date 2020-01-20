package ru.napoleonit.settings.api

//import ru.napoleonit.MainFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Inject

class SettingsScreenFeatureImpl @Inject constructor() : ScreenFeatureApi {

    override fun getScreen(): SupportAppScreen = object : SupportAppScreen(){}

}