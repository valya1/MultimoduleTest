package ru.napoleonit.common.di

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import dagger.android.support.AndroidSupportInjection

class InjectionLifecycleCallback : FragmentManager.FragmentLifecycleCallbacks() {

    override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
        super.onFragmentCreated(fm, f, savedInstanceState)

//        if (f is InjectionFragment) AndroidSupportInjection.inject(f)
    }
}