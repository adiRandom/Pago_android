package com.example.page_android_junior.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.example.page_android_junior.models.User
import com.example.page_android_junior.models.constants.UserStatus
import com.example.page_android_junior.services.api.ApiInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception


class ContactsScreenFragmentViewModel : ViewModel() {
    val contacts: LiveData<List<User>> = liveData {
        emit(emptyList())
        withContext(Dispatchers.IO) {
            try {
                val res = ApiInstance.UserApi.getUserInfoList().execute()
                val body = res.body();
                if (body != null) {
                    // Only keep the active users
                    val users = body.map { User(it) }.filter { it->it.status == UserStatus.ACTIVE }

                    // Emit the users without the avatars for a fast initial load
                    emit(users)

                    // Now load the avatars of all the users that need
                    // After an avatar gets loaded emit the new value so we don't wait until all of them are loaded to draw the final UI

                    // The objects in the users list are referenced already in other parts of the app
                    // Create a new list to load the avatars into to not mutate those references
                    val usersWithAvatar = users.map{it->User(it)}
                    for (user in usersWithAvatar) {
                        user.loadAvatar()
                        if (user.avatar != null) {
                            // An avatar was loaded so emit the new value for liveData
                            emit(usersWithAvatar)
                        }
                    }


                }
            } catch (e: Exception) {
                Log.e("Error", e.toString())
            }
        }
    }
    val contactCount: LiveData<Int> = Transformations.map(contacts) { it.size }


}