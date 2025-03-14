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
        } catch (t: Throwable) {
            println("$tag (Error): ${t.message}")
            throw t
        }
    }

    override  suspend fun doSignUp(email: String, password: String) : AuthResult? {
        return try {
            auth.createUserWithEmailAndPassword(email, password)
        } catch (t: Throwable) {
            println("$tag (Error): ${t.message}")
            throw t
        }
    }

    override suspend fun doSignOut() {
        try {
            auth.signOut()
        } catch (t: Throwable) {
            println("$tag (Error): ${t.message}")
            throw t
        }
    }

}