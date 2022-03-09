package com.example.page_android_junior.models

import com.example.page_android_junior.models.api.ApiUser

class User(
    id: Int,
    name: String,
    email: String,
    gender: String,
    status: String
) : ApiUser(id, name, email, gender, status) {
//TODO: Handle image
}