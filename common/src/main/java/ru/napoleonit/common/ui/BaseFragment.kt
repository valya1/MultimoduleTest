package ru.napoleonit.common.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    @get: LayoutRes
    abstract val layoutId: Int?

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return if (layoutId == null)
            super.onCreateView(inflater, container, savedInstanceState)
        else
            inflater.inflate(layoutId!!, container, false)
    }

}