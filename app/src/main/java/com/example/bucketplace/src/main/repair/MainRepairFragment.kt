package com.example.bucketplace.src.main.repair

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.bucketplace.R
import com.example.bucketplace.config.BaseFragment
import com.example.bucketplace.databinding.FragmentMainRepairBinding
import com.example.bucketplace.src.main.CartActivity
import com.example.bucketplace.src.main.home.popular.PopularBannerAdapter
import com.example.bucketplace.util.AdFragment

class MainRepairFragment :
    BaseFragment<FragmentMainRepairBinding>(FragmentMainRepairBinding::bind, R.layout.fragment_main_repair) {

    var currentPosition = 0

    val handler = Handler(Looper.getMainLooper()) {
//       setPage()
        true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivCart.setOnClickListener {
            startActivity(Intent(context, CartActivity::class.java))
        }

        val fragmentList = listOf(
            AdFragment(R.drawable.ad_repair_1),
            AdFragment(R.drawable.ad_repair_2),
            AdFragment(R.drawable.ad_repair_3),
            AdFragment(R.drawable.ad_repair_4),
            AdFragment(R.drawable.ad_repair_5),
        )
        val adapter = PopularBannerAdapter(activity as FragmentActivity)
        adapter.fragments = fragmentList
        binding.vpRepair.adapter = adapter

        val mIndicator = binding.vpAdIndi
        mIndicator.setViewPager(binding.vpRepair)
        mIndicator.createIndicators(adapter.itemCount, 0)

        binding.vpRepair.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                if (positionOffsetPixels == 0) {
                    binding.vpRepair.currentItem = position
                }
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                mIndicator.animatePageSelected(position % adapter.itemCount)
            }
        })


        val thread = Thread(MyPagePagerRunnable())
        thread.start()
    }

    private fun setPage() {
        while (currentPosition == 5)
            currentPosition = 0
            binding.vpRepair.currentItem = currentPosition
            currentPosition += 1
    }

    inner class MyPagePagerRunnable : Runnable {
        override fun run() {
            while (true) {
                Thread.sleep(2000) //추후 4000(4초)로 변경
                handler.sendEmptyMessage(0)
            }
        }
    }

}
