package ru.napoleonit.settings.ui

import android.os.Bundle
import android.transition.*
import android.view.View
import androidx.core.app.SharedElementCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.settings_fragment.*
import ru.napoleonit.common.ui.BaseFragment
import ru.napoleonit.common.ui.FragmentTransactionDelegate
import ru.napoleonit.settings.R
import ru.napoleonit.settings.dependency.SettingsDependencies
import ru.napoleonit.settings.ui.kittens_list.adapter.KittensAdapter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class KittensFragment : BaseFragment() {

    @Inject
    lateinit var dependencies: SettingsDependencies

    @Inject
    lateinit var localRouter: Router

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

        kittensAdapter = KittensAdapter { imageView, resource ->
            fragmentManager?.commit {

                //                setReorderingAllowed(true)

                val detailsFragment = KittenDetailContainerFragment.newInstance(resource)
                    .apply {
                        sharedElementEnterTransition = createTransition()
                        sharedElementReturnTransition = createTransition()
                        enterTransition = Fade()
                    }

                replace(R.id.llFragmentContainer, detailsFragment)
                addSharedElement(imageView, resources.getString(R.string.transition_name_kitten))
                addToBackStack(null)
            }
        }

        rvKittens.adapter = kittensAdapter
    }

//    override fun prepareTransaction(fragmentTransaction: FragmentTransaction, nextFragment: Fragment) {
//
//        fragmentTransaction.addSharedElement()
//
//    }


    private fun createTransition(): Transition {
        return TransitionSet().apply {
            ordering = TransitionSet.ORDERING_TOGETHER
            duration = 1000
//            startDelay = 700
            addTransition(ChangeBounds())
            addTransition(ChangeTransform())
//            addTransition(ChangeClipBounds())
            addTransition(ChangeImageTransform())
        }
    }
}