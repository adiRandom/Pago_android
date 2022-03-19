package com.example.pago_android_junior.routes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pago_android_junior.R
import com.example.pago_android_junior.adaptors.contacts_screen.ContactsListAdaptor
import com.example.pago_android_junior.databinding.ContactScreeenFragmentBinding
import com.example.pago_android_junior.models.User
import com.example.pago_android_junior.viewmodels.ContactsScreenFragmentViewModel

// This fragment holds the UI and VM for the contact screen
class ContactsScreenFragment : Fragment() {

    private lateinit var binding: ContactScreeenFragmentBinding;
    private lateinit var contactsListAdapter: ContactsListAdaptor

    private val viewModel: ContactsScreenFragmentViewModel by viewModels()

    fun updateContactList(contacts:List<User>){
        if (contactsListAdapter.contacts.size != contacts.size) {
            // The lists are different so we need a full update
            contactsListAdapter.updateData(contacts)
        }
        // See which items changed and notify the Contact List
        contacts.forEachIndexed { index, contact ->
            if (contact != contactsListAdapter.contacts[index]) {
                contactsListAdapter.updateItem(contact, index)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // bind the contact list from the VM to the contact list RecyclerView
        viewModel.contacts.observe(this){
            updateContactList(it)
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ContactScreeenFragmentBinding.inflate(inflater, container, false)

        // Init the RecyclerList for the contacts
        val contactListLayoutManager = LinearLayoutManager(activity)
        contactsListAdapter = ContactsListAdaptor(viewModel.contacts.value ?: emptyList())
        binding.contactsList.also {
            it.adapter = contactsListAdapter
            it.layoutManager = contactListLayoutManager
        }

        // Pass the contact count to the data binding and specify the lifecycle owner for the LiveData to work properly
        binding.contactCount = viewModel.contactCount;
        binding.lifecycleOwner = viewLifecycleOwner;

        return binding.root

    }


}