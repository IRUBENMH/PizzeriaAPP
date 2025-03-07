package com.irubenmh.kmp.pizzeria.error.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.irubenmh.kmp.pizzeria.common.vm.BaseViewModel
import com.irubenmh.kmp.pizzeria.error.data.model.ErrorContext

@Composable
fun ErrorController(
    viewModel: BaseViewModel,
    navController: NavController,
    route: String,
    context: ErrorContext
) {
    val error by viewModel.error.collectAsStateWithLifecycle()
    when(context) {
        ErrorContext.DEFAULT -> {}
        else -> {
            baseErrorStateHandler(
                errorState = error.errorState,
                navController = navController,
                route = route,
                viewModel = viewModel
            )
        }
    }
}