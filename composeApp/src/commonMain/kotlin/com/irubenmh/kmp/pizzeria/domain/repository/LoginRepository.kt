package com.irubenmh.kmp.pizzeria.domain.repository

interface LoginRepository {
    fun doLogin(email: String, password: String)
    fun doRegister(email: String, password: String)
    fun doLogout()
}