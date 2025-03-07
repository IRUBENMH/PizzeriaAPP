package com.irubenmh.kmp.pizzeria.main.data

sealed class Routes(val name: String) {
    data object Register : Routes("register")
    data object Login : Routes("login")
    data object Home : Routes("home")
    data object Error : Routes("error")
}