package com.example.bucketplace.src.main

import android.os.Bundle
import android.view.View
import com.example.bucketplace.R
import com.example.bucketplace.config.BaseFragment
import com.example.bucketplace.databinding.FragmentMainHomeBinding
import com.example.bucketplace.databinding.FragmentMainMyPageBinding

class MainMyPageFragment : BaseFragment<FragmentMainMyPageBinding>(FragmentMainMyPageBinding::bind, R.layout.fragment_main_my_page){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}