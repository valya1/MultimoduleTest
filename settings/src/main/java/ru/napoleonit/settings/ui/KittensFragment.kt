package ru.napoleonit.settings.ui

import android.os.Bundle
import android.transition.*
import android.view.View
import androidx.core.app.SharedElementCallback
import androidx.fragment.app.commit
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.settings_fragment.*
import ru.napoleonit.common.ui.BaseFragment
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

    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setExitSharedElementCallback(object : SharedElementCallback() {

            override fun onMapSharedElements(
                names: MutableList<String>,
                sharedElements: MutableMap<String, View>
            ) {
                super.onMapSharedElements(names, sharedElements)

//                sharedElements[names[0]] = rvKittens.findViewHolderForAdapterPosition(0)!!.itemView
            }

        })

//        sharedElementReturnTransition = createTransition()
//        exitTransition = Fade().apply { duration = 700 }

        kittensAdapter = KittensAdapter { imageView, resource ->
            parentFragment?.childFragmentManager?.commit {

                val detailsFragment = KittenDetailFragment.newInstance(resource)
                    .apply {
                        sharedElementEnterTransition = createTransition()
                        enterTransition = Fade().apply { duration = 700 }
                    }

                replace(R.id.llFragmentContainer, detailsFragment)
//                setReorderingAllowed(true)
                addSharedElement(imageView, resources.getString(R.string.transition_name_kitten))
                addToBackStack(null)
            }
        }

        rvKittens.adapter = kittensAdapter
    }


    private fun createTransition(): Transition {
        return TransitionSet().apply {
            ordering = TransitionSet.ORDERING_TOGETHER
            duration = 1000
            startDelay = 700
            addTransition(ChangeBounds())
            addTransition(ChangeTransform())
            addTransition(ChangeClipBounds())
            addTransition(ChangeImageTransform())
        }
    }
}