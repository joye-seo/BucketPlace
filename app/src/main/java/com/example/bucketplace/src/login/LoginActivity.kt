package com.example.bucketplace.src.login

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bucketplace.R
import com.example.bucketplace.config.BaseActivity
import com.example.bucketplace.databinding.ActivityLoginBinding
import com.example.bucketplace.databinding.ActivitySplashSecondBinding

var isLogin: Boolean = false

lateinit var editor: SharedPreferences.Editor

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}