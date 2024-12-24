package com.irubenmh.kmp.pizzeria.data.service

import dev.gitlive.firebase.auth.AuthResult

interface LoginService {
    suspend fun doSignIn(email: String, password: String) : AuthResult?
    suspend fun doSignUp(email: String, password: String) : AuthResult?
    suspend fun doSignOut()
}