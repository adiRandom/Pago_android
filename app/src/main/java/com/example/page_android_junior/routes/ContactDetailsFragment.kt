package com.example.page_android_junior.routes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.page_android_junior.adaptors.contact_details.PostListAdaptor
import com.example.page_android_junior.adaptors.contacts_screen.ContactsListAdaptor
import com.example.page_android_junior.databinding.ContactDetailsFragmentBinding
import com.example.page_android_junior.viewmodels.ContactDetailsViewModel

class ContactDetailsFragment : Fragment() {

    private lateinit var binding: ContactDetailsFragmentBinding;
    private lateinit var postListAdaptor: PostListAdaptor
    val args: ContactDetailsFragmentArgs by navArgs()
    private val viewModel: ContactDetailsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Bind the posts list on the VM to the RecyclerView
        viewModel.getPosts().observe(this) {
            postListAdaptor.updateData(it)
        }

        //Request the posts for this user
        viewModel.loadPostsForUser(args.user.id)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = ContactDetailsFragmentBinding.inflate(inflater, container, false)
        // Init the data binding
        binding.user = args.user
        binding.postCount = viewModel.postCount;

        // Tell the binding who owns the lifecycle of any LiveData sent through data binding
        binding.lifecycleOwner = viewLifecycleOwner

        // Init the RecyclerView for the posts
        val postListLayoutManager = LinearLayoutManager(activity)
        postListAdaptor = PostListAdaptor(viewModel.getPosts().value ?: emptyList())
        binding.contactDetailsPostList.also {
            it.adapter = postListAdaptor
            it.layoutManager = postListLayoutManager
        }

        // Bind the back button to the back navigation
        binding.backButton.setOnClickListener {
            val action = ContactDetailsFragmentDirections.goBack()
            findNavController().navigateUp()
        }
        return binding.root

    }


}