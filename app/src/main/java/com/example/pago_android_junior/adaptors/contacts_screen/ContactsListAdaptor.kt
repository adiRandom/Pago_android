package com.example.pago_android_junior.adaptors.contacts_screen

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pago_android_junior.databinding.ContactViewHolderBinding
import com.example.pago_android_junior.models.User
import com.example.pago_android_junior.view_holders.contacts_screen.ContactViewHolder

class ContactsListAdaptor(_contacts: List<User>) :
    RecyclerView.Adapter<ContactViewHolder>() {

    var contacts = _contacts.toMutableList();
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ContactViewHolderBinding.inflate(inflater, parent, false);


        return ContactViewHolder(binding);
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val user = contacts[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return contacts.size;
    }

    fun updateData(data: List<User>) {
        contacts = data.toMutableList()
        notifyDataSetChanged()
    }

    /**
     * Update the element at a given index
     * More efficient than updating the whole list, since this way we can tell teh RecyclerView to only redraw parts of the UI
     */
    fun updateItem(item: User, index: Int) {
        Log.d("Changed", index.toString())
        contacts[index] = item;
        notifyItemChanged(index)
    }

}