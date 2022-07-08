package com.example.bucketplace.src.main.home.pro

import android.os.Bundle
import android.view.View
import com.example.bucketplace.R
import com.example.bucketplace.config.BaseFragment
import com.example.bucketplace.databinding.FragmentMainHomeProBinding

class MainHomeProFragment :
    BaseFragment<FragmentMainHomeProBinding>(
        FragmentMainHomeProBinding::bind,
        R.layout.fragment_main_home_pro
    ) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}