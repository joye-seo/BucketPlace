package com.example.bucketplace.src.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bucketplace.R
import com.example.bucketplace.config.BaseActivity
import com.example.bucketplace.databinding.ActivityMainBinding

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

    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.mainFragment.id, fragment)
            .commit()
    }
}


