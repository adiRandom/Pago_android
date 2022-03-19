package com.example.page_android_junior.models

import android.content.Context
import android.graphics.Bitmap
import androidx.core.content.res.ResourcesCompat
import com.example.page_android_junior.R
import com.example.page_android_junior.models.api.UserApi
import com.example.page_android_junior.utils.image.generateAvatarForUser
import com.squareup.picasso.Picasso

const val IMAGE_URL = "https://picsum.photos/200/200 "

class User(
    id: Int,
    name: String,
    email: String,
    gender: String,
    status: String,

    ) : UserApi(id, name, email, gender, status) {
    lateinit var avatar: Bitmap

    constructor(userApi: UserApi) : this(
        userApi.id,
        userApi.name,
        userApi.email,
        userApi.gender,
        userApi.status,
    );

    fun initAvatar(context: Context?) {

        if (this::avatar.isInitialized) {
            // The avatar was already init
            return;
        }

        // Init the avatar
        if (id % 2 == 0) {
            if (context == null) {
                return;
            }
            // Generate a image with the initials of the user
            avatar = generateAvatarForUser(
                this,
                // Get the font using the context of this view
                ResourcesCompat.getFont(context, R.font.sf_pro_text_bold)
            )
        } else {
            // GET an image from the web
//            TODO: Handle error
            val image = Picasso.get().load(IMAGE_URL).get();
            if (image != null) {
                avatar = image;
            }
        }
    }
}