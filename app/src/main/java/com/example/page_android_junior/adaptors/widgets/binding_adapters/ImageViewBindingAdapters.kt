package com.example.page_android_junior.adaptors.widgets.binding_adapters

import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import com.example.page_android_junior.R
import com.example.page_android_junior.models.api.User
import com.example.page_android_junior.utils.image.generateAvatarForUser
import com.squareup.picasso.Picasso


const val IMAGE_URL = "https://picsum.photos/200/200 "

@BindingAdapter("imageForUser")
fun setImageBasedOnUserId(view: ImageView, user: User) {
    if (user.id % 2 == 0) {
        // Generate a image with the initials of the user
        view.apply {
            setImageBitmap(
                generateAvatarForUser(
                    user,
                    // Get the font using the context of this view
                    ResourcesCompat.getFont(context, R.font.sf_pro_text_bold)
                )
            )
        }
    } else {
        // GET an image from the web
//            TODO: Handle error
        Picasso.get().load(IMAGE_URL).into(view);
    }
}