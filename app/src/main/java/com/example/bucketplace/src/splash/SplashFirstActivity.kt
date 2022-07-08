package com.example.bucketplace.src.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.bucketplace.config.BaseActivity
import com.example.bucketplace.databinding.ActivitySplachFirstBinding

class SplashFirstActivity : BaseActivity<ActivitySplachFirstBinding>(ActivitySplachFirstBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({

            val intent = Intent(this, SplashSecondActivity::class.java)
            startActivity(intent)
            finish()

        }, 1500)
    }
}