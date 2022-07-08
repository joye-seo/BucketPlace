package com.example.bucketplace.util

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bucketplace.databinding.ItemRepairAdBinding

class AdFragment (val image:Int): Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = ItemRepairAdBinding.inflate(layoutInflater)

        binding.ivAdSlide.setImageResource(image)

        return binding.root
    }
}