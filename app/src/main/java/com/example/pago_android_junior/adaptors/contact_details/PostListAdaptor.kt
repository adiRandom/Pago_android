package com.example.pago_android_junior.adaptors.contact_details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pago_android_junior.databinding.ContactViewHolderBinding
import com.example.pago_android_junior.databinding.PostViewHolderBinding
import com.example.pago_android_junior.models.Post
import com.example.pago_android_junior.models.User
import com.example.pago_android_junior.view_holders.contact_details.PostViewHolder
import com.example.pago_android_junior.view_holders.contacts_screen.ContactViewHolder

class PostListAdaptor(private var posts: List<Post>) :
    RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        // Inflate the View for a post
        val inflater = LayoutInflater.from(parent.context)
        val binding = PostViewHolderBinding.inflate(inflater, parent, false);
        return PostViewHolder(binding);
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int {
        return posts.size;
    }

    /**
     * Update the data displayed by this RecyclerView
     */
    fun updateData(data: List<Post>) {
        posts = data;
        // Trigger a full redraw
        notifyDataSetChanged()
    }

}