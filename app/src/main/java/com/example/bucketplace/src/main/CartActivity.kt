package com.example.bucketplace.src.main

import android.os.Bundle
import com.example.bucketplace.config.BaseActivity
import com.example.bucketplace.databinding.ActivityCartBinding

class CartActivity : BaseActivity<ActivityCartBinding>(ActivityCartBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnBack.setOnClickListener {
            finish()
        }

    }
}