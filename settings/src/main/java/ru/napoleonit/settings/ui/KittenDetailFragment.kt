package ru.napoleonit.settings.ui

import android.app.SharedElementCallback
import android.os.Bundle
import android.view.View
import androidx.annotation.DrawableRes
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.fragment_kitten_details.*
import ru.napoleonit.common.ui.BaseFragment
import ru.napoleonit.settings.R

class KittenDetailFragment : BaseFragment() {

    companion object {
        fun newInstance(@DrawableRes kittenResource: Int): KittenDetailFragment {
            return KittenDetailFragment().apply {
                arguments = bundleOf("RESOURCE" to kittenResource)
            }
        }
    }

    override val layoutId = R.layout.fragment_kitten_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btnBack.setOnClickListener {
            fragmentManager?.popBackStack()
        }

        setEnterSharedElementCallback(object : androidx.core.app.SharedElementCallback() {

            override fun onMapSharedElements(
                names: MutableList<String>,
                sharedElements: MutableMap<String, View>
            ) {
                super.onMapSharedElements(names, sharedElements)

//                sharedElements[names[0]] = ivKitten
            }
        })
    }
}