package ru.napoleonit.common.navigation

import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

fun Fragment.toScreen(): SupportAppScreen {
    return object : SupportAppScreen() {
        override fun getFragment() = this@toScreen
    }
}