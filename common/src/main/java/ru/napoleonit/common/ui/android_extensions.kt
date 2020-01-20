package ru.napoleonit.common.ui

import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen


inline fun <reified TF : Fragment> Fragment.toFragment(): TF? {

    val classLoader = activity?.classLoader ?: return null

    return fragmentManager?.fragmentFactory
        ?.instantiate(classLoader, TF::class.java.canonicalName!!) as? TF
}

inline fun <reified TF : Fragment> Fragment.createAppScreen(): SupportAppScreen =
    object : SupportAppScreen() {
        override fun getFragment(): Fragment? = toFragment<TF>()
    }

//inline fun <reified TF : Fragment> Activity.createAppScreen(): SupportAppScreen =
//    object : SupportAppScreen() {
//        override fun getFragment(): Fragment {
//            return
//        }
//    }
