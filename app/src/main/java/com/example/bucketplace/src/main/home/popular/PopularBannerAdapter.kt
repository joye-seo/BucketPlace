package com.example.bucketplace.src.main.home.popular

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PopularBannerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    var fragments = listOf<Fragment>()

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments.get(position)
    }

}