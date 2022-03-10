package com.example.page_android_junior.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.page_android_junior.models.api.User
import com.example.page_android_junior.services.api.ApiInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContactsScreenFragmentViewModel : ViewModel() {
    val contacts: LiveData<List<User>> = liveData {
        // Set the initial value
        emit(emptyList<User>())
        withContext(Dispatchers.IO) {
            val res = ApiInstance.UserApi.getUserInfoList().execute()
            val body = res.body();
            if(body != null) {
                emit(body)
            }
        }
    }

}