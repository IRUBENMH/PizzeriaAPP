package com.irubenmh.kmp.pizzeria.data.service

import dev.gitlive.firebase.auth.AuthResult
import dev.gitlive.firebase.auth.FirebaseAuth

class LoginServiceImpl(
    private val auth: FirebaseAuth
) : LoginService  {
    private val tag = "LoginService"
    override suspend fun doSignIn(email: String, password: String) : AuthResult? {
        return try {
            auth.signInWithEmailAndPassword(email, password)
        } catch (e: Exception) {
            println("$tag (Error): ${e.message}")
            null
        }
    }

    override  suspend fun doSignUp(email: String, password: String) : AuthResult? {
        return try {
            auth.createUserWithEmailAndPassword(email, password)
        } catch (e: Exception) {
            println("$tag (Error): ${e.message}")
            null
        }
    }

    override suspend fun doSignOut() {
        try {
            auth.signOut()
        } catch (e: Exception) {
            println("$tag (Error): ${e.message}")
        }
    }

}