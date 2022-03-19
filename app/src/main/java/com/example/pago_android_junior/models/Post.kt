package com.example.pago_android_junior.models

import com.example.pago_android_junior.models.api.ApiPost

class Post(apiPost: ApiPost) {
    val Id: Int
    val UserId: Int
    val Title: String
    val Body: String

    init {
        this.Body = apiPost.body
        this.Id = apiPost.id
        this.UserId = apiPost.user_id
        this.Title = apiPost.title
    }
}