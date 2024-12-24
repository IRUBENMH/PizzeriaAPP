package com.irubenmh.kmp.pizzeria.domain.repository

import dev.gitlive.firebase.auth.AuthResult

interface LoginRepository {
    suspend fun doSignIn(email: String, password: String) : AuthResult?
    suspend fun doSignUp(email: String, password: String) : AuthResult?
    suspend fun doSignOut()
}