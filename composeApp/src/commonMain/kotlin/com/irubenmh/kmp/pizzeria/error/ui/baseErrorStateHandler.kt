package com.irubenmh.kmp.pizzeria.error.ui

import androidx.navigation.NavController
import com.irubenmh.kmp.pizzeria.common.vm.BaseViewModel
import com.irubenmh.kmp.pizzeria.error.data.model.BaseErrorState
import com.irubenmh.kmp.pizzeria.error.data.model.ErrorState
import com.irubenmh.kmp.pizzeria.main.data.Routes


fun baseErrorStateHandler(
    errorState: ErrorState,
    navController: NavController,
    route: String,
    viewModel: BaseViewModel
) {
    when (errorState) {
        BaseErrorState.NO_ERROR -> {}
        BaseErrorState.UNAUTHORIZED_ERROR -> { navController.navigate(Routes.Login.name) }
        BaseErrorState.CONNECTION_ERROR -> { navController.navigate("${Routes.Error.name}/${errorState.message ?: "Error de conexión"}/$route") }
        else -> { navController.navigate("${Routes.Error.name}/${errorState.message ?: "Error inesperado"}/$route") }
    }
    viewModel.clearErrorState()
}
