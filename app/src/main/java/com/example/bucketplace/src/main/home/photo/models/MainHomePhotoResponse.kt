package com.example.bucketplace.src.main.home.photo.models

data class MainHomePhotoResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)