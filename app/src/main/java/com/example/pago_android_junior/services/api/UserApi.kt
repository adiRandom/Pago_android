package com.example.pago_android_junior.services.api

import com.example.pago_android_junior.models.api.ApiPost
import com.example.pago_android_junior.models.api.UserApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("users")
    fun getUserInfoList(): Call<List<UserApi>>;

    @GET("users/{userId}/posts")
    fun getPostsForUserWithId(@Path("userId") userId: Int): Call<List<ApiPost>>
}






