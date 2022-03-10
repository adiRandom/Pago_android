package com.example.page_android_junior.utils.image

import android.R.attr
import android.content.Context
import android.graphics.*
import android.graphics.Color.parseColor
import com.example.page_android_junior.models.api.User


const val AVATAR_TEXT_SIZE = 17f
const val AVATAR_TEXT_COLOR = Color.WHITE;
val AVATAR_BACKGROUND_COLOR = parseColor("#C1C8D7");
const val AVATAR_SIZE = 46

// TODO: Cache the avatars
fun generateAvatarForUser(user: User, typeface: Typeface): Bitmap {

    // Get a paint object to draw on the canvas with
    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = AVATAR_TEXT_SIZE;
        color = AVATAR_TEXT_COLOR
        textAlign = Paint.Align.CENTER
        this.typeface = typeface
    }


    // Create a backing bitmap for our canvas
    val image = Bitmap.createBitmap(
        AVATAR_SIZE, AVATAR_SIZE, Bitmap.Config.ARGB_8888
    )

    val canvas = Canvas(image)
    canvas.drawColor(AVATAR_BACKGROUND_COLOR)
    // Extract the capitalized initials
    val avatarText =
        user.name.split(" ").map { it.first().toString().uppercase() }.reduce { acc, s -> acc + s }
//    TODO: Check that 0
//    TODO: Check the allignment of the text
    //Draw the text on the canvas
    canvas.drawText(avatarText, 0f, -paint.ascent(), paint)
    return image
}