package ru.napoleonit.common.ui

import androidx.fragment.app.FragmentTransaction

interface ExitTransitionHandler {
    fun prepareExitTransitions(transaction: FragmentTransaction)
}
