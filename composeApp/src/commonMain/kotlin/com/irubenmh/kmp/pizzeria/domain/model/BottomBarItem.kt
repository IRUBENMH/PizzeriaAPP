package com.irubenmh.kmp.pizzeria.domain.model

import androidx.compose.ui.graphics.painter.Painter
import org.jetbrains.compose.resources.StringResource

data class BottomBarItem(
    val name: StringResource,
    val icon: Painter,
    val description: StringResource,
    val id: StringResource,
    val route: String
)