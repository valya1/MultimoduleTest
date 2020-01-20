package ru.napoleonit.common.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import java.lang.Exception
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

//class InjectionFragmentFactory @Inject constructor(
//    private val loaders: Map<Class<out Fragment>, Provider<Fragment>>
//) : FragmentFactory() {
//    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
//
//        val fragmentClass = loadFragmentClass(classLoader, className)
//        return try {
//            val loader = loaders[fragmentClass]
//            super.instantiate(classLoader, className)
//        } catch (ex: Exception) {
//            throw RuntimeException(ex)
//        }
//    }
//}