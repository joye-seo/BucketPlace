package com.example.bucketplace.src.main.store.plan

import android.os.Bundle
import android.view.View
import com.example.bucketplace.R
import com.example.bucketplace.config.BaseFragment
import com.example.bucketplace.databinding.FragmentMainStorePlanBinding

class MainStorePlanFragment :
    BaseFragment<FragmentMainStorePlanBinding>(
        FragmentMainStorePlanBinding::bind,
        R.layout.fragment_main_store_plan
    ) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}