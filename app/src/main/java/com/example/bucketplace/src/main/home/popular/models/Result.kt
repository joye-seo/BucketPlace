package com.example.bucketplace.src.main.home.popular.models

data class Result(
    val categories: List<Category>,
    val eventBanners: List<EventBanner>,
    val eventIcons: List<EventIcon>,
    val housewarms: List<Housewarm>,
    val knowhows: List<Knowhow>,
    val proHousewarms: List<ProHousewarm>
)