package com.example.bucketplace.src.main.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.example.bucketplace.R
import com.example.bucketplace.config.BaseFragment
import com.example.bucketplace.databinding.FragmentMainHomeBinding
import com.example.bucketplace.src.main.CartActivity
import com.example.bucketplace.src.main.home.follow.MainHomeFollowFragment
import com.example.bucketplace.src.main.home.house.MainHomeHouseFragment
import com.example.bucketplace.src.main.home.knowHow.MainHomeKnowHowFragment
import com.example.bucketplace.src.main.home.photo.MainHomePhotoFragment
import com.example.bucketplace.src.main.home.popular.MainHomePopularFragment
import com.example.bucketplace.src.main.home.pro.MainHomeProFragment
import com.example.bucketplace.src.main.home.qna.MainHomeQnaFragment
import com.example.bucketplace.src.main.store.best.MainStoreBestFragment
import com.example.bucketplace.src.main.store.deal.MainStoreDealFragment
import com.example.bucketplace.src.main.store.fastShipping.MainStoreFastShippingFragment
import com.example.bucketplace.src.main.store.goods.MainStoreGoodsFragment
import com.example.bucketplace.src.main.store.limited.MainStoreLimitedFragment
import com.example.bucketplace.src.main.store.plan.MainStorePlanFragment
import com.example.bucketplace.src.main.store.premium.MainStorePremiumFragment
import com.example.bucketplace.src.main.store.reaper.MainStoreReaperFragment
import com.example.bucketplace.src.main.store.storeHome.MainStoreStoreHomeFragment
import com.example.bucketplace.util.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainHomeFragment : BaseFragment<FragmentMainHomeBinding>(FragmentMainHomeBinding::bind, R.layout.fragment_main_home){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

        binding.ivCart.setOnClickListener {
            Log.d("text","tes")
            startActivity(Intent(context, CartActivity::class.java))
        }

    }

    private fun initView() {

        val fragmentList = listOf(
            MainHomePopularFragment(),
            MainHomeFollowFragment(),
            MainHomePhotoFragment(),
            MainHomeHouseFragment(),
            MainHomeKnowHowFragment(),
            MainHomeProFragment(),
            MainHomeQnaFragment()
        )
        val adapter = ViewPagerAdapter(activity as FragmentActivity)
        adapter.fragments = fragmentList
        binding.vpHome.adapter = adapter
        binding.vpHome.requestDisallowInterceptTouchEvent(true)
        TabLayoutMediator(binding.layoutTap, binding.vpHome,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {
                    0 -> tab.text = "인기"
                    1 -> tab.text = "팔로잉"
                    2 -> tab.text = "사진"
                    3 -> tab.text = "집들이"
                    4 -> tab.text = "노하우"
                    5 -> tab.text = "전문가집들이"
                    6 -> tab.text = "질문과답변"
                }
            }
        ).attach()

    }
}