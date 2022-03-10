package com.example.page_android_junior.models.api

import com.example.page_android_junior.services.api.ApiInstance


open class User(
    val id: Int,
    val name: String,
    val email: String,
    val gender: String,
//    This could be a Enum if all the known values were known
    val status: String
)

