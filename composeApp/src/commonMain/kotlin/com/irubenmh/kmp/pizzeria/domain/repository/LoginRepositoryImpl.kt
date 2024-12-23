package com.irubenmh.kmp.pizzeria.domain.repository

import com.irubenmh.kmp.pizzeria.data.service.LoginService


class LoginRepositoryImpl(
    private val loginService: LoginService
) : LoginRepository {
    override fun doLogin(email: String, password: String) {
        loginService.doLogin(email, password)
    }

    override fun doRegister(email: String, password: String) {
        loginService.doRegister(email, password)
    }

    override fun doLogout() {
        loginService.doLogout()
    }
}