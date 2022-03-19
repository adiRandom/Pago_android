package com.example.page_android_junior.models.api

import android.graphics.Bitmap
import android.media.Image
import android.os.Parcelable
import androidx.core.content.res.ResourcesCompat
import com.example.page_android_junior.R
import com.example.page_android_junior.services.api.ApiInstance
import com.squareup.picasso.Picasso
import kotlinx.parcelize.Parcelize

open class UserApi(
    val id: Int,
    val name: String,
    val email: String,
    val gender: String,
//    This could be a Enum if all the known values were known
    val status: String,
);

