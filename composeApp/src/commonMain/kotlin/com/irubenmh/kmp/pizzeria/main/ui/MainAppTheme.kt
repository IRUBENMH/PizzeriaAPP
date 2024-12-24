package com.irubenmh.kmp.pizzeria.main.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.irubenmh.kmp.pizzeria.main.ui.theme.onPrimary
import com.irubenmh.kmp.pizzeria.main.ui.theme.onSecondary
import com.irubenmh.kmp.pizzeria.main.ui.theme.onSurface
import com.irubenmh.kmp.pizzeria.main.ui.theme.onTertiary
import com.irubenmh.kmp.pizzeria.main.ui.theme.primary
import com.irubenmh.kmp.pizzeria.main.ui.theme.secondary
import com.irubenmh.kmp.pizzeria.main.ui.theme.surface
import com.irubenmh.kmp.pizzeria.main.ui.theme.tertiary

@Composable
fun MainAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme.copy(
            primary = primary,
            onPrimary = onPrimary,
            secondary = secondary,
            onSecondary = onSecondary,
            tertiary = tertiary,
            onTertiary = onTertiary,
            surface = surface,
            onSurface =  onSurface
        )
    ){
        content()
    }
}