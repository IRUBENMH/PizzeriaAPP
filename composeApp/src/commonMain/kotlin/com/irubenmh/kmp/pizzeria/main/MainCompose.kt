package com.irubenmh.kmp.pizzeria.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.irubenmh.kmp.pizzeria.feature.auth.ui.LoginView


@Composable
fun MainCompose() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginView(navController)
        }
    }
}