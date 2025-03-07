package com.irubenmh.kmp.pizzeria.common.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun MainText(
    modifier: Modifier = Modifier,
    text: String,
    initialFontSize: TextUnit = 14.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    adjustment : Float = 0.9f,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    color: Color = MaterialTheme.colorScheme.primary,
) {
    var textSize by remember { mutableStateOf(initialFontSize) }
    Text(
        modifier = modifier,
        text = text,
        color = color,
        lineHeight = lineHeight,
        fontSize = textSize,
        fontWeight = fontWeight,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow,
        onTextLayout = { textLayoutResult ->
            val currentMaxLineIndex = textLayoutResult.lineCount - 1
            if (textLayoutResult.isLineEllipsized(currentMaxLineIndex)) {
                textSize *= adjustment

            }

        }
    )
}
