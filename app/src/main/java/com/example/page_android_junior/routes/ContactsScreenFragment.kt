package com.example.page_android_junior.routes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.page_android_junior.R
import com.example.page_android_junior.adaptors.contacts_screen.ContactsListAdaptor
import com.example.page_android_junior.databinding.ContactScreeenFragmentBinding
import com.example.page_android_junior.viewmodels.ContactsScreenFragmentViewModel

// This fragment holds the UI and VM for the contact screen
class ContactsScreenFragment : Fragment() {

    private lateinit var binding: ContactScreeenFragmentBinding;
    private lateinit var contactsListAdapter: ContactsListAdaptor
    private val viewModel: ContactsScreenFragmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // New users loaded, init their avatars then
        // bind the contact list from the VM to the contact list RecyclerView
        viewModel.getContacts().observe(this) {
            it.forEach { user ->
                user.initAvatar(context);
            }
            contactsListAdapter.updateData(it)
        }

        // Load the contacts when the fragment gets created
        viewModel.loadContacts(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ContactScreeenFragmentBinding.inflate(inflater, container, false)

        // Init the RecyclerList for the contacts
        val contactListLayoutManager = LinearLayoutManager(activity)
        contactsListAdapter = ContactsListAdaptor(emptyList())
        binding.contactsList.also {
            it.adapter = contactsListAdapter
            it.layoutManager = contactListLayoutManager
        }

        return binding.root

    }


}