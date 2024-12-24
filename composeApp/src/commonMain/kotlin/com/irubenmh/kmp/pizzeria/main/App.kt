package com.irubenmh.kmp.pizzeria.main

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.irubenmh.kmp.pizzeria.main.ui.MainAppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    KoinContext {
        MainAppTheme {
            Surface {
                MainCompose()
            }
        }
    }

}