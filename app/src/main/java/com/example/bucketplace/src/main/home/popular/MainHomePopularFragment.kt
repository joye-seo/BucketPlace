package com.example.bucketplace.src.main.home.popular

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.bucketplace.R
import com.example.bucketplace.config.BaseFragment
import com.example.bucketplace.databinding.FragmentMainHomePopularBinding


class MainHomePopularFragment : BaseFragment<FragmentMainHomePopularBinding>(
    FragmentMainHomePopularBinding::bind,
    R.layout.fragment_main_home_popular
) {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }


}
