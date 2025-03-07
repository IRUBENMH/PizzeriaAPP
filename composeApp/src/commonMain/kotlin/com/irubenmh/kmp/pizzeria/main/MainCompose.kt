package com.irubenmh.kmp.pizzeria.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.irubenmh.kmp.pizzeria.error.ui.ErrorView
import com.irubenmh.kmp.pizzeria.feature.auth.ui.LoginView
import com.irubenmh.kmp.pizzeria.feature.home.ui.HomeView
import com.irubenmh.kmp.pizzeria.main.data.Routes


@Composable
fun MainCompose() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Login.name
    ) {
        composable(Routes.Login.name) {
            LoginView(navController)
        }
        composable(Routes.Home.name) {
            HomeView(navController)
        }
        composable(Routes.Register.name) {
            LoginView(navController)
        }

        composable(
            route = "${Routes.Error.name}/{errorStateMessage}/{route}",
            arguments = listOf(
                navArgument("errorStateMessage") { type = NavType.StringType},
                navArgument("route") { type = NavType.StringType}
            )
        ) {
            val errorMessage = it.arguments?.getString("errorStateMessage") ?: "Error inesperado"
            val route = it.arguments?.getString("route") ?: Routes.Home.name
            ErrorView(navController, errorMessage, route)
        }

    }
}