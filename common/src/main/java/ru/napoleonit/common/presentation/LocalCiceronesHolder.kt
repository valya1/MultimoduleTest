package ru.napoleonit.common.presentation

import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

class LocalCiceronesHolder {

    private val cicerones = HashMap<String, Cicerone<Router>>()

    @Synchronized
    fun getOrCreate(key: String) = cicerones.getOrPut(key, { Cicerone.create() })

}