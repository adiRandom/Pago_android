package com.example.page_android_junior.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.example.page_android_junior.models.Post
import com.example.page_android_junior.models.api.ApiPost
import com.example.page_android_junior.services.api.ApiInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContactDetailsViewModel : ViewModel() {
    private val posts: MutableLiveData<List<Post>> by lazy {
        MutableLiveData<List<Post>>(emptyList())
    }

    fun getPosts(): LiveData<List<Post>> = posts;

    fun loadPostsForUser(userId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val postsRes = ApiInstance.UserApi.getPostsForUserWithId(userId).execute().body();
            if (postsRes != null) {
                posts.postValue(postsRes.map { Post(it) })
            }
        }
    }
}