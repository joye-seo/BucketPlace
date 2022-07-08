package com.example.bucketplace.src.main.home.house.models

data class Housewarm(
    val housewarmIdx: Int,
    val imgUrl: String,
    val scrap: String,
    val title: String,
    val users: List<User>,
    val views: String
)