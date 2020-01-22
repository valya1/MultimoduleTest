package ru.napoleonit.common.navigation.router

import android.view.View
import ru.napoleonit.common.navigation.command.ForwardWithSharedElements
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Screen

class TransitionsRouter : Router() {

    fun navigateWithTransitions(screen: Screen, sharedElements: Map<View, String>) {
        executeCommands(ForwardWithSharedElements(screen, sharedElements))
    }
}