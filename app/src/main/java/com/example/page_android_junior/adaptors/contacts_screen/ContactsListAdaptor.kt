package com.example.page_android_junior.adaptors.contacts_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.page_android_junior.databinding.ContactViewHolderBinding
import com.example.page_android_junior.models.api.User
import com.example.page_android_junior.view_holders.contacts_screen.ContactViewHolder

class ContactsListAdaptor(private var contacts: List<User>) :
    RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ContactViewHolderBinding.inflate(inflater,parent,false);
        return ContactViewHolder(binding);
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(contacts[position])
    }

    override fun getItemCount(): Int {
        return contacts.size;
    }

    fun updateData(data:List<User>){
        contacts = data;
        notifyDataSetChanged()
    }

}