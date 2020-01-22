package ru.napoleonit.common.ui

import androidx.fragment.app.FragmentTransaction

interface EnterTransitionHandler {
    fun prepareEnterTransitions(fragmentTransaction: FragmentTransaction)
}
