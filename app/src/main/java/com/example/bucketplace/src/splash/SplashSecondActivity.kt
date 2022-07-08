package com.example.bucketplace.src.splash

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.bucketplace.config.ApplicationClass.Companion.sSharedPreferences
import com.example.bucketplace.config.BaseActivity
import com.example.bucketplace.databinding.ActivitySplashSecondBinding
import com.example.bucketplace.src.login.LoginActivity
import com.example.bucketplace.src.login.editor
import com.example.bucketplace.src.login.isLogin
import com.example.bucketplace.src.main.MainActivity
import com.example.bucketplace.util.ActivityUtil.bucketPlaceStartActivity
import timber.log.Timber

class SplashSecondActivity : BaseActivity<ActivitySplashSecondBinding>(ActivitySplashSecondBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // //로그인 했는지 확인
        sSharedPreferences = getSharedPreferences("X-ACCESS-TOKEN", Activity.MODE_PRIVATE)
        editor = sSharedPreferences.edit()

        val jwt = sSharedPreferences.getString("X_ACCESS_TOKEN", null)

        //jwt값이 존재하면 바로 로그인할 수 있게끔(isLogin == true) 자동로그인 구현
        isLogin = jwt != null

        Handler(Looper.getMainLooper()).postDelayed({
            if (isLogin) {
                Timber.tag("Refresh").d("자동로그인 O - MainActivity")
                bucketPlaceStartActivity<MainActivity> { }
            } else {
                Timber.tag("Refresh").d("자동로그인 X - LoginActivity")
                bucketPlaceStartActivity<LoginActivity> { }

            }
        }, 1500)
    }

}