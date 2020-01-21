package ru.napoleonit.settings.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.layout_kitten_detail.*
import ru.napoleonit.settings.R

class KittenDetailFragment : Fragment() {


    companion object {

        const val ARGS = "args"

        fun newInstance(url: String): KittenDetailFragment {
            return KittenDetailFragment().apply {
                arguments = bundleOf(ARGS to url)
            }
        }
    }

    private val args by lazy {
        arguments!!.getString(ARGS)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.layout_kitten_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        ivKitten.transitionName = args

        btnBack.setOnClickListener {
            parentFragment?.fragmentManager?.popBackStack()
        }

        Glide.with(view)
            .load(args)
            .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
            .addListener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    parentFragment?.startPostponedEnterTransition()
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    if (args == KittensFragment.LINK2) parentFragment?.startPostponedEnterTransition()
                    return false
                }
            })
            .into(ivKitten)

    }
}