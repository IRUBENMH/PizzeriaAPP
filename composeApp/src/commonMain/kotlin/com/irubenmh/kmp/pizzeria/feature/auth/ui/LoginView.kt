package com.irubenmh.kmp.pizzeria.feature.auth.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.irubenmh.kmp.pizzeria.common.component.MainButton
import com.irubenmh.kmp.pizzeria.common.component.MainScreen
import com.irubenmh.kmp.pizzeria.common.component.MainText
import com.irubenmh.kmp.pizzeria.common.component.MainTextButton
import com.irubenmh.kmp.pizzeria.common.component.MainTextField
import com.irubenmh.kmp.pizzeria.feature.auth.vm.LoginViewModel
import com.irubenmh.kmp.pizzeria.main.ui.theme.onPrimary
import com.irubenmh.kmp.pizzeria.main.ui.theme.onSurface
import com.irubenmh.kmp.pizzeria.main.ui.theme.primary
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
    MainScreen {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LoginContent(navController, viewModel)
        }
    }
}

@Composable
fun LoginContent(
    navController: NavController,
    viewModel: LoginViewModel
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxHeight(0.45f)
            .fillMaxWidth(0.8f)
            .border(2.dp, Color.Black, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
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
    Column(
        modifier = modifier.padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        MainText(
            text = "Bienvenido",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = primary
        )
        MainText(
            text = "Inicia sesión para acceder a la App",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = primary
        )
    }

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
            onValueChange = {
                viewModel.setUsername(it)
                            },
            label = "Nombre de usuario",
            placeholder = "Nombre de usuario",
            trailingIcon = {
                IconButton(
                    onClick = { viewModel.setUsername("") }
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
    val isLoginEnabled by viewModel.isLoginEnabled.collectAsState()
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(-(8.dp))
    ) {
        MainButton(
            text = "INICIAR SESIÓN",
            enabled = isLoginEnabled,
            shape = RoundedCornerShape(12.dp),
            borderStroke = if (!isLoginEnabled) BorderStroke(2.dp, primary) else null
        ) {
            viewModel.doLogin()
        }

        MainTextButton(
            text = "Crear cuenta"
        ) {
            navController.navigate("register")
        }
    }

}