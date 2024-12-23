package com.irubenmh.kmp.pizzeria.data.service

interface LoginService {
    fun doLogin(email: String, password: String)
    fun doRegister(email: String, password: String)
    fun doLogout()
}