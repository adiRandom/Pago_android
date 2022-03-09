package com.example.page_android_junior.services.api

import retrofit2.Retrofit

class ApiInstance {
    companion object {
        private val retrofitClient = Retrofit.Builder().baseUrl("https://gorest.co.in/public/v2").build()

        // UserApi
        val UserApi = retrofitClient.create(UserApi::class.java)

    }

}

