package ru.napoleonit.settings.ui

import ru.napoleonit.common.ui.ContainerFragment
import ru.napoleonit.common.ui.createAppScreen
import ru.terrakok.cicerone.android.support.SupportAppScreen

class KittensContainerFragment : ContainerFragment() {

    override val firstScreen: SupportAppScreen = createAppScreen<KittensFragment>()
}