package com.example.bucketplace.src.main.store.goods

import android.os.Bundle
import android.view.View
import com.example.bucketplace.R
import com.example.bucketplace.config.BaseFragment
import com.example.bucketplace.databinding.FragmentMainStoreGoodsBinding

class MainStoreGoodsFragment :
    BaseFragment<FragmentMainStoreGoodsBinding>(
        FragmentMainStoreGoodsBinding::bind,
        R.layout.fragment_main_store_goods
    ) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}