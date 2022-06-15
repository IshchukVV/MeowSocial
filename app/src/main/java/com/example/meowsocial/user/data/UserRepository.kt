package com.example.meowsocial.user.data

import androidx.lifecycle.LiveData
import com.example.meowsocial.user.data.User

interface UsersRepository {
    fun getUsers(): LiveData<List<User>>
    fun currentUid(): String?
    fun getUser(): LiveData<User>
    fun getUser(uid: String): LiveData<User>
}