package com.irubenmh.kmp.pizzeria.domain.repository

import com.irubenmh.kmp.pizzeria.data.service.LoginService
import dev.gitlive.firebase.auth.AuthResult


class LoginRepositoryImpl(
    private val loginService: LoginService
) : LoginRepository {
    override suspend fun doSignIn(email: String, password: String): AuthResult? {
        return loginService.doSignIn(email, password)
    }

    override suspend fun doSignUp(email: String, password: String): AuthResult? {
        return loginService.doSignUp(email, password)
    }

    override suspend fun doSignOut() {
        loginService.doSignOut()
    }

}