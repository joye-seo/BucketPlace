package com.example.bucketplace.src.main.home.house.models

data class MainHomeHouseResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)