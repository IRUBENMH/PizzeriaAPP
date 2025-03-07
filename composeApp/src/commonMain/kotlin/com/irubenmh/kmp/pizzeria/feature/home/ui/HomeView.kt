package com.irubenmh.kmp.pizzeria.feature.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.irubenmh.kmp.pizzeria.common.component.Screen
import com.irubenmh.kmp.pizzeria.error.data.model.ErrorContext
import com.irubenmh.kmp.pizzeria.feature.home.vm.HomeViewModel
import com.irubenmh.kmp.pizzeria.main.data.Routes
import org.koin.compose.viewmodel.koinViewModel
import pizzeriaapp.composeapp.generated.resources.Res
import pizzeriaapp.composeapp.generated.resources.home_view_title

@Composable
fun HomeView(
    navController: NavController,
    viewModel: HomeViewModel = koinViewModel()
) {

    Screen(
        navController = navController,
        viewModel = viewModel,
        title = Res.string.home_view_title,
        route = Routes.Home.name,
        context = ErrorContext.HOME,
    ) { paddingValues ->
        HomeContent(paddingValues, navController, viewModel)

    }
}

@Composable
fun HomeContent(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: HomeViewModel
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(paddingValues)
    ) {

    }
}
