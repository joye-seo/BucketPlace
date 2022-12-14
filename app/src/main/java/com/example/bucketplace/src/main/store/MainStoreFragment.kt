package com.example.bucketplace.src.main.store

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.example.bucketplace.R
import com.example.bucketplace.config.BaseFragment
import com.example.bucketplace.databinding.FragmentMainStoreBinding
import com.example.bucketplace.src.main.CartActivity
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

class MainStoreFragment : BaseFragment<FragmentMainStoreBinding>(
    FragmentMainStoreBinding::bind,
    R.layout.fragment_main_store
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        binding.ivCart.setOnClickListener {
            startActivity(Intent(context, CartActivity::class.java))
        }

    }

    private fun initView() {

        val fragmentList = listOf(
            MainStoreStoreHomeFragment(),
            MainStoreBestFragment(),
            MainStoreDealFragment(),
            MainStoreLimitedFragment(),
            MainStoreReaperFragment(),
            MainStoreGoodsFragment(),
            MainStoreFastShippingFragment(),
            MainStorePremiumFragment(),
            MainStorePlanFragment(),
        )
        val adapter = ViewPagerAdapter(activity as FragmentActivity)
        adapter.fragments = fragmentList
        binding.vpStore.adapter = adapter
        binding.vpStore.requestDisallowInterceptTouchEvent(true)
        TabLayoutMediator(binding.layoutTap, binding.vpStore,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {
                    0 -> tab.text = "????????????"
                    1 -> tab.text = "?????????"
                    2 -> tab.text = "????????????"
                    3 -> tab.text = "7???????????????"
                    4 -> tab.text = "????????????"
                    5 -> tab.text = "???!??????"
                    6 -> tab.text = "????????????"
                    7 -> tab.text = "????????????"
                    8 -> tab.text = "?????????"
                }
            }
        ).attach()


    }
}