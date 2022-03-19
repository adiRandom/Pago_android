package com.example.page_android_junior.adaptors.widgets.binding_adapters

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("src")
fun setImageBitmap(view: ImageView, bitmap: Bitmap?) {
    if(bitmap != null) {
        view.setImageBitmap(bitmap)
    }
}