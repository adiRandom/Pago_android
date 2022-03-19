package com.example.pago_android_junior.services.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiInstance {
    companion object {
        private val retrofitClient = Retrofit.Builder()
            .baseUrl("https://gorest.co.in/public/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // UserApi
        val UserApi = retrofitClient.create(UserApi::class.java)

    }

}

