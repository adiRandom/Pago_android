package com.example.pago_android_junior.view_holders.contacts_screen

import androidx.navigation.findNavController
import com.example.pago_android_junior.databinding.ContactViewHolderBinding
import com.example.pago_android_junior.models.User
import com.example.pago_android_junior.models.api.UserApi
import com.example.pago_android_junior.routes.ContactsScreenFragmentDirections
import com.example.pago_android_junior.view_holders.generic.ListViewHolder

class ContactViewHolder(val viewBinding: ContactViewHolderBinding) :
    ListViewHolder<User>(viewBinding) {

    override fun bind(item: User) {
        this.viewBinding.user = item

        // Bind the on click handler to navigate to the contact screen
        this.viewBinding.contactViewHolderRoot.setOnClickListener {
            val action = ContactsScreenFragmentDirections.openContactDetails(item)
            it.findNavController().navigate(action)
        }
    }

}