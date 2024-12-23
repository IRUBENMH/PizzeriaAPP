package com.irubenmh.kmp.pizzeria.feature.auth.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.irubenmh.kmp.pizzeria.common.component.MainScreen
import com.irubenmh.kmp.pizzeria.common.component.MainTextField
import com.irubenmh.kmp.pizzeria.feature.auth.vm.LoginViewModel
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import pizzeriaapp.composeapp.generated.resources.Res
import pizzeriaapp.composeapp.generated.resources.close
import pizzeriaapp.composeapp.generated.resources.hide_password
import pizzeriaapp.composeapp.generated.resources.show_password

@Composable
fun LoginView(
    navController: NavController,
    viewModel: LoginViewModel = koinViewModel()
) {
    MainScreen(
        verticalArrangement = Arrangement.Center
    ) {
        LoginContent(navController, viewModel)
    }
}

@Composable
fun LoginContent(
    navController: NavController,
    viewModel: LoginViewModel
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth(0.8f)
            .border(2.dp, Color.Black, RoundedCornerShape(16.dp))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        LoginTitle(
            modifier = Modifier.align(Alignment.TopCenter)
        )
        LoginInputData(
            modifier = Modifier.align(Alignment.Center),
            viewModel = viewModel
        )
        LoginButtons(
            modifier = Modifier.align(Alignment.BottomCenter),
            viewModel = viewModel,
            navController = navController
        )
    }
}

@Composable
fun LoginTitle(modifier: Modifier) {
    Text(
        text = "Bienvenido",
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}


@Composable
fun LoginInputData(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel
) {
    Column(
        modifier = modifier
    ) {
        val username by viewModel.username.collectAsState()
        val password by viewModel.password.collectAsState()
        MainTextField(
            value = username,
            onValueChange = { viewModel.setUsername(it) },
            label = "Nombre de usuario",
            placeholder = "Nombre de usuario",
            focusSensitive = true,
            trailingIcon = {
                IconButton(
                    onClick = {viewModel.setUsername("") }
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.close),
                        contentDescription = "Clear Username"
                    )
                }
            }
        )
        var visibility by remember { mutableStateOf(false) }
        MainTextField(
            value = password,
            onValueChange = { viewModel.setPassword(it) } ,
            label = "Contraseña",
            placeholder = "Contraseña",
            visualTransformation = if (visibility) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(
                    onClick = { visibility = !visibility }
                ) {
                    Icon(
                        painter = if (!visibility) (painterResource(Res.drawable.show_password)) else painterResource(Res.drawable.hide_password),
                        contentDescription = "Show/Hide Password"
                    )
                }
            }
        )
    }
}

@Composable
fun LoginButtons(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: LoginViewModel
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(-(16.dp))
    ) {
        Button(
            onClick = {

            }
        ) {
            Text(text = "Iniciar sesión")
        }

        TextButton(onClick = {})  {
            Text(
                text = "Crear cuenta",
                fontSize = 10.sp
            )
        }
    }

}