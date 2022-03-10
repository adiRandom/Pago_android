package com.example.page_android_junior.adaptors.widgets.binding_adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.page_android_junior.models.api.User

@BindingAdapter("imageForUser")
fun setImageBasedOnUserId(view: ImageView, user: User) {
    if(user.id % 2 == 0){
        // Generate a image with the initials of the user
    }
}