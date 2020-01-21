package ru.napoleonit.common.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import ru.napoleonit.common.R
import ru.napoleonit.common.navigation.LocalCiceronesHolder
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.android.support.SupportAppScreen
import ru.terrakok.cicerone.commands.Command
import javax.inject.Inject

abstract class ContainerFragment : BaseFragment(), HasAndroidInjector {

    abstract val firstScreen: SupportAppScreen

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var localCiceronesHolder: LocalCiceronesHolder

    private val key = this::class.java.simpleName

    val router: Router by lazy {
        localCiceronesHolder.getOrCreate(key).router
    }

    private val navigatorHolder: NavigatorHolder by lazy {
        localCiceronesHolder.getOrCreate(key).navigatorHolder
    }

    private lateinit var navigator: Navigator

    override val layoutId: Int = R.layout.fragment_container

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigator =SupportAppNavigator(
            activity,
            childFragmentManager,
            R.id.llFragmentContainer
        )

        router.navigateTo(firstScreen)
    }

    override fun onResume() {
        super.onResume()

        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}