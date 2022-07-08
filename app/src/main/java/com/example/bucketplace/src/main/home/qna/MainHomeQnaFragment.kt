package com.example.bucketplace.src.main.home.qna

import android.os.Bundle
import android.view.View
import com.example.bucketplace.R
import com.example.bucketplace.config.BaseFragment
import com.example.bucketplace.databinding.FragmentMainHomeQnaBinding

class MainHomeQnaFragment :
    BaseFragment<FragmentMainHomeQnaBinding>(
        FragmentMainHomeQnaBinding::bind,
        R.layout.fragment_main_home_qna
    ) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}