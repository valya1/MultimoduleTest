package ru.napoleonit.settings.ui.kittens_list.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_kitten_details.view.*
import kotlinx.android.synthetic.main.item_kitten.view.*
import ru.napoleonit.settings.R
import ru.napoleonit.settings.ui.KittensFragment

class KittensAdapter(val kittenResourceClickListener: (View, String) -> Unit) :
    RecyclerView.Adapter<KittensAdapter.KittenViewHolder>() {

    override fun getItemCount() = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KittenViewHolder {
        return KittenViewHolder(parent.context.inflateView(R.layout.item_kitten, parent))
    }

    override fun onBindViewHolder(holder: KittenViewHolder, position: Int) {
        return holder.bind(position)
    }

    inner class KittenViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int) {

            val url = if (position == 0) KittensFragment.LINK else KittensFragment.LINK2
            itemView.transitionName = url

            Glide.with(itemView)
                .load(url)
                .into(itemView as ImageView)

            itemView.setOnClickListener {
                kittenResourceClickListener.invoke(itemView.ivKitten, url)
            }
        }
    }


}


fun Context.inflateView(@LayoutRes layoutId: Int, container: ViewGroup): View {
    return LayoutInflater.from(this).inflate(layoutId, container, false)
}