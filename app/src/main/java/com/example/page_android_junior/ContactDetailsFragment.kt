package com.example.page_android_junior

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.page_android_junior.databinding.ContactDetailsFragmentBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ContactDetailsFragment : Fragment() {

    private lateinit var binding: ContactDetailsFragmentBinding;


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = ContactDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }


}