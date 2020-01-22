package ru.napoleonit.settings.ui

import android.app.SharedElementCallback
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.Fade
import android.transition.Transition
import android.transition.TransitionSet
import android.view.View
import androidx.core.view.doOnLayout
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.settings_fragment.*
import ru.napoleonit.common.navigation.router.TransitionsRouter
import ru.napoleonit.common.navigation.toScreen
import ru.napoleonit.common.ui.BaseFragment
import ru.napoleonit.common.ui.ExitTransitionHandler
import ru.napoleonit.settings.R
import ru.napoleonit.settings.dependency.SettingsDependencies
import ru.napoleonit.settings.ui.kittens_list.adapter.KittensAdapter
import ru.terrakok.cicerone.Router
import java.util.*
import javax.inject.Inject

class KittensFragment : BaseFragment(), ExitTransitionHandler {

    @Inject
    lateinit var dependencies: SettingsDependencies

    @Inject
    lateinit var localRouter: TransitionsRouter

    lateinit var kittensAdapter: KittensAdapter

    override val layoutId = R.layout.settings_fragment

    companion object {
        const val LINK2 = "https://нашсамогон.рф/pictures/product/big/6866_big.jpg"
        const val LINK =
            "https://agro63.ru/wa-data/public/shop/products/90/49/4990/images/6030/6030.750.jpg"
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setExitSharedElementCallback(object : androidx.core.app.SharedElementCallback() {
            override fun onMapSharedElements(
                names: MutableList<String>,
                sharedElements: MutableMap<String, View>
            ) {
                super.onMapSharedElements(names, sharedElements)
//                sharedElements[names[0]] = rvKittens.findViewHolderForAdapterPosition(0)!!.itemView
            }
        })

        kittensAdapter = KittensAdapter { imageView, resource ->

            val fragment = KittenDetailContainerFragment.newInstance(resource).apply {
                sharedElementEnterTransition = createTransition()
                sharedElementReturnTransition = createTransition()
            }

            requireFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .addSharedElement(imageView, resource)
                .addToBackStack("test")
                .replace(
                    R.id.llFragmentContainer, fragment, "test"
                )
                .commit()
//        }

//            localRouter.navigateWithTransitions(
//                KittenDetailContainerFragment.newInstance(resource).apply {
//                    sharedElementEnterTransition = createTransition()
//                    sharedElementReturnTransition = createTransition()
//                }.toScreen(),
//                mapOf(imageView to resource)
//            )
        }
        rvKittens.adapter = kittensAdapter

        rvKittens.viewTreeObserver.addOnPreDrawListener {

            startPostponedEnterTransition()
            true
        }
    }

    override fun prepareExitTransitions(transaction: FragmentTransaction) = Unit

    private fun createTransition(): Transition {
        return TransitionSet().apply {
            ordering = TransitionSet.ORDERING_TOGETHER
            duration = 1000
            addTransition(AutoTransition())
//            addTransition(ChangeBounds())
//            addTransition(ChangeTransform())
//            addTransition(ChangeClipBounds())
//            addTransition(ChangeImageTransform())
        }
    }
}