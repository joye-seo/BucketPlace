package com.example.bucketplace.src.main.store.limited

import android.os.Bundle
import android.view.View
import com.example.bucketplace.R
import com.example.bucketplace.config.BaseFragment
import com.example.bucketplace.databinding.FragmentMainStoreLimitedBinding

class MainStoreLimitedFragment :
    BaseFragment<FragmentMainStoreLimitedBinding>(
        FragmentMainStoreLimitedBinding::bind,
        R.layout.fragment_main_store_limited
    ) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}