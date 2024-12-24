package com.irubenmh.kmp.pizzeria.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.irubenmh.kmp.pizzeria.main.ui.theme.onPrimary
import com.irubenmh.kmp.pizzeria.main.ui.theme.primary

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
    colors: TextFieldColors = mainOutlinedTextFieldColor(),
    focusSensitive: Boolean = false
) {
    var hasFocus by remember { mutableStateOf(false) }
    OutlinedTextField(
        modifier = modifier
            .onFocusChanged { hasFocus = it.hasFocus },
        value = value,
        onValueChange = onValueChange,
        label = {
            MainText(
                text = label,
                fontWeight = if (hasFocus) FontWeight.Bold else FontWeight.Normal
            )
        },
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
        },
        colors = colors
    )
}

@Composable
fun mainOutlinedTextFieldColor() : TextFieldColors {
    return TextFieldDefaults.colors().copy(
        focusedTextColor = primary,
        unfocusedTextColor = primary,
        focusedContainerColor = onPrimary,
        unfocusedContainerColor = onPrimary,
        focusedIndicatorColor = primary,
        unfocusedIndicatorColor = primary,
        focusedLabelColor = primary,
        unfocusedLabelColor = primary
    )


}