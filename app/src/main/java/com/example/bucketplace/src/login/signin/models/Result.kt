package com.example.bucketplace.src.login.signin.models

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("jwt") val jwt: String,
    @SerializedName("userIdx") val userIdx: Int
)