package com.example.bucketplace.src.login.signin.models

import com.google.gson.annotations.SerializedName

data class SignInResponse(
        @SerializedName("result") val result: Result,
        @SerializedName("isSuccess") val isSuccess: Boolean,
        @SerializedName("code") val code: Int,
        @SerializedName("message") val message: String
)
