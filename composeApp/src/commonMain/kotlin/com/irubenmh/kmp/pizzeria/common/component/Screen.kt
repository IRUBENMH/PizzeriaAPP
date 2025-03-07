package com.irubenmh.kmp.pizzeria.common.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.irubenmh.kmp.pizzeria.common.vm.BaseViewModel
import com.irubenmh.kmp.pizzeria.error.data.model.ErrorContext
import com.irubenmh.kmp.pizzeria.error.ui.ErrorController
import com.irubenmh.kmp.pizzeria.main.data.Routes
import com.irubenmh.kmp.pizzeria.popup.PopUpController
import org.jetbrains.compose.resources.StringResource

@Composable
fun Screen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: BaseViewModel,
    title: StringResource,
    extraTitle: String? = null,
    scaffold: Boolean = true,
    route: String = Routes.Home.name,
    actions: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    fabPosition: FabPosition = FabPosition.End,
    context: ErrorContext,
    content: @Composable (PaddingValues) -> Unit
) {
    MaterialTheme {
        Surface(
            modifier = modifier.fillMaxSize(),
        ) {
            PopUpController(viewModel)
            ErrorController(
                viewModel = viewModel,
                navController = navController,
                route = route,
                context = context
            )
            if (scaffold) {
                MainScaffold(
                    modifier = modifier,
                    navController = navController,
                    title = title,
                    extraTitle = extraTitle,
                    actions = actions,
                    floatingActionButton = floatingActionButton,
                    fabPosition = fabPosition
                ) { paddingValues ->
                    content(paddingValues)

                }
            } else {
                content(PaddingValues(0.dp))
            }
        }
    }
}