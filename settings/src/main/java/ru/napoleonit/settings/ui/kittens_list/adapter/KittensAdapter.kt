package ru.napoleonit.settings.ui.kittens_list.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_kitten_details.view.*
import ru.napoleonit.settings.R

class KittensAdapter(val kittenResourceClickListener: (View, Int) -> Unit) :
    RecyclerView.Adapter<KittensAdapter.KittenViewHolder>() {

    override fun getItemCount() = 3

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KittenViewHolder {
        return KittenViewHolder(parent.context.inflateView(R.layout.item_kitten, parent))
    }

    override fun onBindViewHolder(holder: KittenViewHolder, position: Int) {
        return holder.bind(position)
    }

    inner class KittenViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int) {

            itemView.ivKitten.transitionName =
                itemView.context.resources.getString(
                    R.string.transition_name_kitten_recycler,
                    position.toString()
                )

            val resource = when (position) {
                0 -> R.drawable.kitten1
                1 -> R.drawable.kitten2
                2 -> R.drawable.kitten3
                else -> -1
            }

            when (position) {
                0 -> itemView.ivKitten.setImageDrawable(
                    ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.kitten1
                    )
                )
                1 -> itemView.ivKitten.setImageDrawable(
                    ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.kitten2
                    )
                )
                2 -> itemView.ivKitten.setImageDrawable(
                    ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.kitten3
                    )
                )

            }

            itemView.setOnClickListener {
                kittenResourceClickListener.invoke(itemView.ivKitten, resource)
            }
        }
    }


}


fun Context.inflateView(@LayoutRes layoutId: Int, container: ViewGroup): View {
    return LayoutInflater.from(this).inflate(layoutId, container, false)
}