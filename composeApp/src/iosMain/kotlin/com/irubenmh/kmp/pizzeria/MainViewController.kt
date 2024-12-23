package com.irubenmh.kmp.pizzeria

import androidx.compose.ui.window.ComposeUIViewController
import com.irubenmh.kmp.pizzeria.di.initKoin
import com.irubenmh.kmp.pizzeria.main.App

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() }
) {
    App()
}