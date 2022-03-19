package com.example.page_android_junior.adaptors.widgets.binding_adapters

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("src")
fun setImageBitmap(view: ImageView, bitmap: Bitmap) {
    view.setImageBitmap(bitmap)
}