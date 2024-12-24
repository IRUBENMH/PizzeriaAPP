package com.irubenmh.kmp.pizzeria.feature.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.irubenmh.kmp.pizzeria.common.component.MainScreen
import com.irubenmh.kmp.pizzeria.feature.home.vm.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeView(
    navController: NavController,
    viewModel: HomeViewModel = koinViewModel()
) {
    MainScreen {
        Scaffold { paddingValues ->
            HomeContent(paddingValues, navController, viewModel)
        }

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
