package com.example.bucketplace.src.main

import android.os.Bundle
import android.view.View
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import com.example.bucketplace.R
import com.example.bucketplace.config.BaseActivity
import com.example.bucketplace.databinding.ActivityMainBinding
import com.example.bucketplace.src.main.home.MainHomeFragment
import com.example.bucketplace.src.main.myPage.MainMyPageFragment
import com.example.bucketplace.src.main.plus.MainPlusFragment
import com.example.bucketplace.src.main.repair.MainRepairFragment
import com.example.bucketplace.src.main.store.MainStoreFragment


class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private lateinit var mainHomeFragment: MainHomeFragment

    private lateinit var mainStoreFragment: MainStoreFragment

    private lateinit var mainRepairFragment: MainRepairFragment

    private lateinit var mainMyPageFragment: MainMyPageFragment

    private lateinit var mainPlusFragment: MainPlusFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavigationBar()
    }

    private fun initNavigationBar() {

        mainHomeFragment = MainHomeFragment()
        mainStoreFragment = MainStoreFragment()
        mainRepairFragment = MainRepairFragment()
        mainMyPageFragment = MainMyPageFragment()
        mainPlusFragment = MainPlusFragment()

        binding.navBottom.run {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.home -> changeFragment(mainHomeFragment)
                    R.id.store -> changeFragment(mainStoreFragment)
                    R.id.repair -> changeFragment(mainRepairFragment)
                    R.id.my_page -> changeFragment(mainMyPageFragment)
                }
                true
            }
            // 초기 프레그먼트 값 세팅!
            selectedItemId = R.id.home

            itemRippleColor = null
            itemIconTintList = null

        }
        // 롱 클릭 시 tooltip 텍스트 안보이게 해줌!
        binding.navBottom
            .menu.forEach {
                binding.navBottom.findViewById<View>(it.itemId).setOnLongClickListener {
                    true
                }
            }
        binding.btnPlus.setOnClickListener {
            binding.btnPlus.animate().rotationBy(45f)
            mainPlusFragment = MainPlusFragment()

            val bottomSheet = mainPlusFragment
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }

    }


    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.mainFragment.id, fragment)
            .commit()
    }
}



