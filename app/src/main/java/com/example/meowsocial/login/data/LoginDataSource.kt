package com.example.meowsocial.login.data

import com.example.meowsocial.base.web.WebApi
import com.example.meowsocial.login.data.webApi.LoginAPI
import com.example.meowsocial.login.data.webApi.LoginRequest
import com.example.meowsocial.login.data.webApi.LoginResponse


class LoginDataSource {
    //TODO: DI
    private val loginApiService = WebApi.getRetrofit()
        .create(LoginAPI::class.java)


    @Throws(Exception::class)
    suspend fun signin(username: String, password: String): LoginResponse {
    //for tests
    //return loginApiService.signin(LoginRequest(username, password))
        return loginApiService.signin(login = username, password = password)
    }

    fun logout() {
        // TODO: revoke authentication
    }
}