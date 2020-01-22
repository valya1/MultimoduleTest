package ru.napoleonit.settings.ui

import android.os.Bundle
import android.transition.*
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_kitten_details.*
import ru.napoleonit.common.ui.BaseFragment
import ru.napoleonit.common.ui.EnterTransitionHandler
import ru.napoleonit.settings.R

class KittenDetailContainerFragment : BaseFragment(), EnterTransitionHandler {

    companion object {

        const val ARGS = "args"

        fun newInstance(url: String): KittenDetailContainerFragment {
            return KittenDetailContainerFragment().apply {
                arguments = bundleOf(ARGS to url)
            }
        }
    }

    private val args by lazy {
        arguments!!.getString(ARGS)
    }

    lateinit var kittensDetailsAdapter: KittensDetailAdapter

    override val layoutId = R.layout.fragment_kitten_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()

        kittensDetailsAdapter = KittensDetailAdapter(this)
        kittensPager.adapter = kittensDetailsAdapter
        kittensPager.setCurrentItem(if (args == KittensFragment.LINK) 0 else 1, false)
    }

    override fun prepareEnterTransitions(fragmentTransaction: FragmentTransaction) {

    }

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