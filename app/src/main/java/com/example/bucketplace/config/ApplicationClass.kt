package com.example.bucketplace.config

import android.app.Application
import android.content.SharedPreferences
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

// 앱이 실행될때 1번만 실행
class ApplicationClass : Application() {

    companion object {

        private var sRetrofit: Retrofit? = null
        val BASE_URL = "https://www.clapserver.shop"

        lateinit var sSharedPreferences: SharedPreferences

        // JWT Token Header 키 값
        val ACCESS_TOKEN = "ACCESS-TOKEN"

        fun getRetrofit(): Retrofit {
            if (sRetrofit == null) {
                sRetrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL) // 어느 서버를 기반으로 움직일 건지에 대한 기반 작성
                    .addConverterFactory(GsonConverterFactory.create()) // gson 라이브러리와 결합
                    .build()
            }
            return sRetrofit!!
        }

    }

    // 앱이 처음 생성되는 순간, SP를 새로 만들어주고, 레트로핏 인스턴스를 생성합니다.
    override fun onCreate() {
        super.onCreate()
        sSharedPreferences =
            applicationContext.getSharedPreferences("TEMPLATE_APP", MODE_PRIVATE)



    }

}
