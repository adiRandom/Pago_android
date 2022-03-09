package com.example.page_android_junior.models

import com.example.page_android_junior.models.api.ApiUser

class User(apiUser: ApiUser) {
    val Id: Int
    val Email: String
    val Gender: String
    val Name: String
    val Status: String

    init {
        this.Email = apiUser.email
        this.Id = apiUser.id
        this.Gender = apiUser.gender
        this.Name = apiUser.name
        this.Status = apiUser.status
    }
}