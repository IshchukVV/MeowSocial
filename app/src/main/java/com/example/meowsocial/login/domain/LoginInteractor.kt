package com.example.meowsocial.login.domain

import com.example.meowsocial.base.DomainException
import com.example.meowsocial.base.Result
import com.example.meowsocial.login.data.LoginDataSource
import com.example.meowsocial.managers.SessionManager
import com.example.meowsocial.managers.toDomainModel

class LoginInteractor {
    //TODO:  DI
    val repository = LoginRepository(LoginDataSource())

    suspend fun login(login: String, pass: String): Result<Unit> {
        val result = repository.signin(login, pass)
        return when (result) {
            is Result.Success -> {
                val token = result.data.token
                val account = result.data.account?.toDomainModel()
                if (token == null || account == null) return Result.Error(DomainException())
                SessionManager.saveSession(account, token)
                Result.Success(Unit)
            }
            is Result.Error -> Result.Error(result.exception)
        }
    }
}


