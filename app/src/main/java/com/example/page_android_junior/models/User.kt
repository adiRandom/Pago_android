package com.example.page_android_junior.models

import android.content.Context
import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import com.example.page_android_junior.R
import com.example.page_android_junior.models.api.UserApi
import com.squareup.picasso.Picasso
import kotlinx.android.parcel.Parcelize
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.reflect.typeOf

const val IMAGE_URL = "https://picsum.photos/200/200 "


class User(
    id: Int,
    name: String,
    email: String,
    gender: String,
    status: String,
) : UserApi(id, name, email, gender, status), Parcelable {
    var avatar: Bitmap? = null

    // Get a string with the initials of the user to use for the avatar if the id is odd
    // Only keep two initials if the user has more than 2 names
    val nameInitials =
        name.split(" ").map { it.first().toString().uppercase() }.reduce { acc, s -> acc + s }
            .subSequence(0, 2)

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
    ) {
        val bitmap = parcel.readParcelable<Bitmap>(Bitmap::class.java.classLoader);
        if (bitmap != null) {
            avatar = bitmap
        }

    }

    constructor(userApi: UserApi) : this(
        userApi.id,
        userApi.name,
        userApi.email,
        userApi.gender,
        userApi.status,
    );


    /**
     * Method to be called after the User object was created to asynchronously load the avatar
     * The function suspends so that more avatars can be loaded at once
     */
    suspend fun loadAvatar() {
        // Load an avatar if needed
        if (id % 2 == 1) {
            // GET an image from the web
            withContext(Dispatchers.IO)
            {
                val image = Picasso.get().load(IMAGE_URL).get();
                if (image != null) {
                    avatar = image;
                }
            }
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id);
        parcel.writeString(name)
        parcel.writeString(email)
        parcel.writeString(gender)
        parcel.writeString(status)
        parcel.writeParcelable(avatar, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun equals(other: Any?): Boolean {
        if (other is User) {
            Log.i("Equals called", (other.name == name && other.email == email && other.avatar == avatar && other.gender == gender && other.status == status).toString())
            return other.name == name && other.email == email && other.avatar == avatar && other.gender == gender && other.status == status
        }
        return super<UserApi>.equals(other)
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}