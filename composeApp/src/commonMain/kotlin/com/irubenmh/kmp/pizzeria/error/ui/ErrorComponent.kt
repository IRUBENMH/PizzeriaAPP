package com.irubenmh.kmp.pizzeria.error.ui

import pizzeriaapp.composeapp.generated.resources.Res
import pizzeriaapp.composeapp.generated.resources.ic_error
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import pizzeriaapp.composeapp.generated.resources.btn_accept

@Composable
fun MessageText(message: String?) {
    Text(
        text = message ?: "Error inesperado",
        color = Color.Black,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .semantics { contentDescription = "error-message" },
        fontSize = 18.sp
    )
}

@Composable
fun HeaderIcon() {
    Image(
        painter = painterResource(Res.drawable.ic_error),
        contentDescription = null
    )
}

@Composable
fun HeaderText(title: String) {
    Text(
        text = title,
        color = Color.Black,
        modifier = Modifier
            .padding(start = 20.dp)
            .semantics { contentDescription = "error-header-title" },
        fontSize = 18.sp
    )
}

@Composable
fun ConfirmButton(navController: NavController, route: String) {
    Button(
        onClick = {
            navController.navigate(route)
        },
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .semantics { contentDescription = "error-confirm-button" },
        shape = ShapeDefaults.ExtraSmall
    ) {
        Text(text = stringResource(Res.string.btn_accept))
    }
}