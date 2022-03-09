package com.example.page_android_junior.services.api

import com.example.page_android_junior.models.api.ApiPost
import com.example.page_android_junior.models.api.ApiUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("/users")
    fun getUserInfoList(): Call<List<ApiUser>>;

    @GET("/users/{userId}/posts")
    fun getPostsForUserWithId(@Path("userId") userId: Int): Call<List<ApiPost>>
}






