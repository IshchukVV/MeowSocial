package com.example.meowsocial.login.domain

import com.example.meowsocial.base.Result
import com.example.meowsocial.login.data.LoginDataSource
import com.example.meowsocial.login.data.webApi.LoginResponse
import java.io.IOException

class LoginRepository(val dataSource: LoginDataSource) {

    suspend fun signin(username: String, password: String): Result<LoginResponse> {
        try {
            val result = dataSource.signin(username, password)
            return Result.Success(result)
        } catch (e: Throwable) {
            //TODO: handle different types of exceptions
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        //user = null
        dataSource.logout()
    }

}