package com.example.bucketplace.config

import com.example.bucketplace.config.ApplicationClass.Companion.ACCESS_TOKEN
import com.example.bucketplace.config.ApplicationClass.Companion.sSharedPreferences
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class XAccessTokenInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()
        val jwtToken: String? = sSharedPreferences.getString(ACCESS_TOKEN, null)
        if (jwtToken != null) {
            builder.addHeader("ACCESS-TOKEN", jwtToken)
        }
        return chain.proceed(builder.build())
    }
}