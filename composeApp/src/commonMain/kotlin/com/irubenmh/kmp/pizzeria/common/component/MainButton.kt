package com.irubenmh.kmp.pizzeria.common.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import com.irubenmh.kmp.pizzeria.main.ui.theme.onPrimary
import com.irubenmh.kmp.pizzeria.main.ui.theme.primary

@Composable
fun MainButton(
    modifier: Modifier = Modifier,
    text : String,
    colorText: Color,
    fontWeight: FontWeight = FontWeight.Bold,
    shape: Shape,
    borderStroke: BorderStroke? = null,
    enabled: Boolean = true,
    buttonColors: ButtonColors = mainButtonColor(),
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = shape,
        border = borderStroke,
        enabled = enabled,
        colors = buttonColors
    ) {
        MainText(
            text = text,
            fontWeight = fontWeight,
            color = colorText
        )
    }
}

@Composable
fun mainButtonColor() :  ButtonColors {
    return ButtonDefaults.buttonColors().copy(
        containerColor = primary ,
        contentColor = onPrimary,
        disabledContainerColor = onPrimary,
        disabledContentColor = primary
    )

}