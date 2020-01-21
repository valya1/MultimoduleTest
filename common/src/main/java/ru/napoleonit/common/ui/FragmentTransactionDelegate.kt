package ru.napoleonit.common.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

interface FragmentTransactionDelegate {

    fun prepareTransaction(fragmentTransaction: FragmentTransaction, nextFragment: Fragment)

}
