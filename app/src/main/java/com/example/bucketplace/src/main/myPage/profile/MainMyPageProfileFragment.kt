package com.example.bucketplace.src.main.myPage.profile

import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.example.bucketplace.R
import com.example.bucketplace.config.BaseFragment
import com.example.bucketplace.databinding.FragmentMainMyPageProfileBinding
import com.example.bucketplace.src.main.home.popular.PopularBannerAdapter
import com.example.bucketplace.util.AdFragment

class MainMyPageProfileFragment : BaseFragment<FragmentMainMyPageProfileBinding>(
    FragmentMainMyPageProfileBinding::bind,
    R.layout.fragment_main_my_page_profile
) {
    var currentPosition = 0

    val handler = Handler(Looper.getMainLooper()) {
        setPage()
        true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spanningString = SpannableString(binding.button.text)
        spanningString.setSpan(StyleSpan(Typeface.BOLD), 8, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spanningString.setSpan(
            ForegroundColorSpan(resources.getColor(R.color.colorMainBlue)),
            8,
            14,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.button.text = spanningString

        val fragmentList = listOf(
            AdFragment(R.drawable.ad_my_page_1),
            AdFragment(R.drawable.ad_my_page_2),
        )
        val adapter = PopularBannerAdapter(activity as FragmentActivity)
        adapter.fragments = fragmentList
        binding.vpMyPageBanner.adapter = adapter

        binding.txtAll.text = fragmentList.size.toString()

        val thread = Thread(MyPagePagerRunnable())
        thread.start()

    }

    private fun setPage() {
        if (currentPosition == 2) currentPosition = 0
        binding.vpMyPageBanner.currentItem = currentPosition
        currentPosition += 1
        binding.tvCurrentPage.text = currentPosition.toString()
    }

    //2초 마다 페이지 넘기기
    inner class MyPagePagerRunnable : Runnable {
        override fun run() {
            while (true) {
                Thread.sleep(2000) //추후 4000(4초)로 변경
                handler.sendEmptyMessage(0)
            }
        }
    }
}