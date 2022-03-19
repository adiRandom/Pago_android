package com.example.page_android_junior.view_holders.contacts_screen

import com.example.page_android_junior.databinding.ContactViewHolderBinding
import com.example.page_android_junior.models.User
import com.example.page_android_junior.models.api.UserApi
import com.example.page_android_junior.view_holders.generic.ListViewHolder

class ContactViewHolder(val viewBinding: ContactViewHolderBinding) :
    ListViewHolder<User>(viewBinding) {

    override fun bind(item: User) {
        this.viewBinding.user = item
    }

}