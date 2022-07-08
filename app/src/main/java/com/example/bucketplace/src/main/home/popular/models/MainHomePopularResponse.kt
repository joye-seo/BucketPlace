package com.example.bucketplace.src.main.home.popular.models

data class MainHomePopularResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)