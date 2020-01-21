package ru.napoleonit.settings.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class KittensDetailAdapter(f: Fragment) : FragmentStateAdapter(f) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int) =
        KittenDetailFragment.newInstance(if (position == 0) KittensFragment.LINK else KittensFragment.LINK2)

}
