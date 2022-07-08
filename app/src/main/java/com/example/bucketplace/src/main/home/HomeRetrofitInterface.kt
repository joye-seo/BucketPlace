package com.example.bucketplace.src.main.home

import com.example.bucketplace.src.main.home.house.models.MainHomeHouseResponse
import com.example.bucketplace.src.main.home.photo.models.MainHomePhotoResponse
import com.example.bucketplace.src.main.home.popular.models.MainHomePopularResponse
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface HomeRetrofitInterface {

    @FormUrlEncoded
    @POST("/populars")
    fun getPopulars(
    ): Call<MainHomePopularResponse>

    @FormUrlEncoded
    @POST("/posts")
    fun getPosts(
    ): Call<MainHomePhotoResponse>

    @FormUrlEncoded
    @POST("/housewarms")
    fun getHousewarms(
    ): Call<MainHomeHouseResponse>

}