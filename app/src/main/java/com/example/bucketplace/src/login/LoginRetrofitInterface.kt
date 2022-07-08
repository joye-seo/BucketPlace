package com.example.bucketplace.src.login

import com.example.bucketplace.src.login.signin.models.SignInResponse
import com.example.bucketplace.src.login.signup.models.SignUpResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginRetrofitInterface {

    @FormUrlEncoded
    @POST("/users/logIn")
    fun postSignIn(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<SignInResponse>

    @FormUrlEncoded
    @POST("/users")
    fun postSignUp(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("passwordCheck") passwordCheck: String,
        @Field("nickname") nickname: String,
//        @Field("agreeAge") agreeAge: Char,
//        @Field("agreeTerms") agreeTerms: Char,
//        @Field("agreePrivacy") agreePrivacy: Char,
//        @Field("agreeAlarm") agreeAlarm: Char,
//        @Field("code") code: String,
        ): Call<SignUpResponse>

}