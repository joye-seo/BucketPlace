package com.example.bucketplace.src.main.myPage

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.bucketplace.R
import com.example.bucketplace.config.BaseFragment
import com.example.bucketplace.databinding.FragmentMainMyPageBinding
import com.example.bucketplace.src.main.CartActivity
import com.example.bucketplace.src.main.myPage.myShopping.MainMyPageMyShoppingFragment
import com.example.bucketplace.src.main.myPage.profile.MainMyPageProfileFragment
import com.example.bucketplace.util.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainMyPageFragment :
    BaseFragment<FragmentMainMyPageBinding>(FragmentMainMyPageBinding::bind, R.layout.fragment_main_my_page) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {

        val fragmentList = listOf(
            MainMyPageProfileFragment(),
            MainMyPageMyShoppingFragment()
        )
        val adapter = ViewPagerAdapter(activity as FragmentActivity)
        adapter.fragments = fragmentList
        binding.vpMyPage.adapter = adapter
        binding.vpMyPage.requestDisallowInterceptTouchEvent(true)
        TabLayoutMediator(binding.layoutTap, binding.vpMyPage,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {
                    0 -> tab.text = "프로필"
                    1 -> tab.text = "나의쇼핑"
                }
            }
        ).attach()

        binding.ivCart.setOnClickListener {
            startActivity(Intent(context, CartActivity::class.java))
        }

        binding.ivShare.setOnClickListener {
            val bottomSheet = ShareBottomSheetItem()
            bottomSheet.show(childFragmentManager, bottomSheet.tag)        }

    }

    private fun changeFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(binding.mainPage.id, fragment)
            .commit()
    }
}