package com.irubenmh.kmp.pizzeria.error.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController

@Composable
fun ErrorView(navController: NavController, message: String, route: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent.copy(0.2f)),
        contentAlignment = Alignment.Center
    ){
        PopUpError(navController, message,route)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopUpError(navController: NavController, message: String?, route: String) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BasicAlertDialog(
            onDismissRequest = {  },
            modifier = Modifier.semantics { contentDescription = "error-view" },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .padding(10.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp)
                            .height(40.dp),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        HeaderIcon()
                        HeaderText("Error")
                    }
                    MessageText(message)

                    ConfirmButton(navController, route)
                }
            }
        }
    }
}