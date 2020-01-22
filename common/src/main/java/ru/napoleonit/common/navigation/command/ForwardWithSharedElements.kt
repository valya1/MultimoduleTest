package ru.napoleonit.common.navigation.command

import android.view.View
import ru.terrakok.cicerone.Screen
import ru.terrakok.cicerone.commands.Forward

open class ForwardWithSharedElements(screen: Screen, val sharedElements: Map<View, String>) :
    Forward(screen)