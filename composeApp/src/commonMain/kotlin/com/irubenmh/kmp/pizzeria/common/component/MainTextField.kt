package com.irubenmh.kmp.pizzeria.common.component

import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun MainTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    maxLines: Int = 1,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable (() -> Unit)? = null,
    focusSensitive: Boolean = false
) {
    var hasFocus by remember { mutableStateOf(false) }
    OutlinedTextField(
        modifier = modifier
            .onFocusChanged { hasFocus = it.hasFocus },
        value = value,
        onValueChange = onValueChange,
        label = { MainText(text = label) },
        placeholder = { MainText(text = placeholder) },
        maxLines = maxLines,
        visualTransformation = visualTransformation,
        trailingIcon = {
            if (focusSensitive) {
                if (hasFocus) {
                    trailingIcon?.invoke()
                }
            } else {
                trailingIcon?.invoke()
            }
        }
    )
}