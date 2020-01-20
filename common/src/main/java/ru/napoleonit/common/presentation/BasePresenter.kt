package ru.napoleonit.common.presentation

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import moxy.MvpPresenter

abstract class BasePresenter<V : BaseView> : MvpPresenter<V>() {

    protected val job = SupervisorJob()
    protected val presenterScope = job + Dispatchers.Main


    override fun onDestroy() {
        super.onDestroy()

        presenterScope.cancel()
    }
}