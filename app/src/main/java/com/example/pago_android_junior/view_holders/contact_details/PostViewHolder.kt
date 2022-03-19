package com.example.pago_android_junior.view_holders.contact_details

import com.example.pago_android_junior.databinding.ContactViewHolderBinding
import com.example.pago_android_junior.databinding.PostViewHolderBinding
import com.example.pago_android_junior.models.Post
import com.example.pago_android_junior.models.User
import com.example.pago_android_junior.view_holders.generic.ListViewHolder

class PostViewHolder(val viewBinding: PostViewHolderBinding) :
    ListViewHolder<Post>(viewBinding) {

    override fun bind(item: Post) {
        this.viewBinding.post = item
    }

}