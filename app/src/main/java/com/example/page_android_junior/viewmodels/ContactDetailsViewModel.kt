package com.example.page_android_junior.viewmodels

import androidx.lifecycle.*
import com.example.page_android_junior.models.Post
import com.example.page_android_junior.models.api.ApiPost
import com.example.page_android_junior.services.api.ApiInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContactDetailsViewModel : ViewModel() {
    val posts: LiveData<List<Post>> by lazy {
        MutableLiveData<List<Post>>(emptyList())
    }

    fun loadPostsForUser(userId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val postsRes = ApiInstance.UserApi.getPostsForUserWithId(userId).execute().body();
            if (postsRes != null) {
                (posts as MutableLiveData).postValue(postsRes.map { Post(it) })
            }
        }
    }
}