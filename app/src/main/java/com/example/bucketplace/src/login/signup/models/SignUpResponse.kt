package com.example.bucketplace.src.login.signup.models

data class SignUpResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
)