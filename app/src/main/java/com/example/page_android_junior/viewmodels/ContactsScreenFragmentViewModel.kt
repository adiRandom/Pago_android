package com.example.page_android_junior.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.example.page_android_junior.models.User
import com.example.page_android_junior.models.api.UserApi
import com.example.page_android_junior.services.api.ApiInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ContactsScreenFragmentViewModel : ViewModel() {
    private val contacts: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>(emptyList())
    }

    fun getContacts(): LiveData<List<User>> = contacts;


    fun loadContacts(context: Context?) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val res = ApiInstance.UserApi.getUserInfoList().execute()
                val body = res.body();
//            TODO: Handle errors in UI
                if (body != null) {
                    val users = body.map { User(it).apply { initAvatar(context) } }
                    contacts.postValue(users);
                }
            } catch (e: Exception) {
                Log.e("Error", e.toString())
            }
        }
    }


}