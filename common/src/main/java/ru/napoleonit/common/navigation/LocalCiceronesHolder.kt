package ru.napoleonit.common.navigation

import ru.napoleonit.common.navigation.router.TransitionsRouter
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalCiceronesHolder @Inject constructor() {

    private val cicerones = HashMap<String, Cicerone<TransitionsRouter>>()

    @Synchronized
    fun getOrCreate(key: String) = cicerones.getOrPut(key, { Cicerone.create(TransitionsRouter()) })

}