package com.irubenmh.kmp.pizzeria.popup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.irubenmh.kmp.pizzeria.common.component.MainText
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import pizzeriaapp.composeapp.generated.resources.Res
import pizzeriaapp.composeapp.generated.resources.alerta_title_popup
import pizzeriaapp.composeapp.generated.resources.btn_accept
import pizzeriaapp.composeapp.generated.resources.btn_no
import pizzeriaapp.composeapp.generated.resources.btn_yes
import pizzeriaapp.composeapp.generated.resources.error_title_popup
import pizzeriaapp.composeapp.generated.resources.ic_error
import pizzeriaapp.composeapp.generated.resources.ic_info
import pizzeriaapp.composeapp.generated.resources.ic_warning
import pizzeriaapp.composeapp.generated.resources.information_title_popup

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopUpComponent(
    modifier: Modifier = Modifier,
    type: PopUpType,
    id: StringResource,
    title: StringResource = when (type) {
        PopUpType.Information -> Res.string.information_title_popup
        PopUpType.Warning -> Res.string.alerta_title_popup
        PopUpType.Error -> Res.string.error_title_popup
    },
    singleButton: Boolean = true,
    horizontalArrangementSingleButton: Arrangement.Horizontal = Arrangement.End,
    shape: RoundedCornerShape = RoundedCornerShape(8.dp),
    onDismissRequest: () -> Unit = {},
    properties: DialogProperties = DialogProperties(),
    message: StringResource,
    textButton: StringResource = Res.string.btn_accept,
    textButtonRight: StringResource = Res.string.btn_no,
    textButtonLeft: StringResource = Res.string.btn_yes,
    onClickRight: () -> Unit = {},
    onClickLeft: () -> Unit = {},
    onClick: () -> Unit = {}
) {
    val popupId =  stringResource(id)
    BasicAlertDialog(
        modifier = modifier,
        onDismissRequest = onDismissRequest,
        properties = properties
    ) {
        Column(
            modifier = Modifier
                .clip(shape = shape)
                .background(Color.White)
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .semantics { contentDescription =  popupId },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Column(
                    modifier = Modifier.weight(0.2f)
                ) {
                        Image(
                            painter = when (type) {
                                PopUpType.Information -> painterResource(Res.drawable.ic_info)
                                PopUpType.Warning -> painterResource(Res.drawable.ic_warning)
                                PopUpType.Error -> painterResource(Res.drawable.ic_error)
                            },
                            contentDescription = "Icon",
                            modifier = Modifier.padding(start = 20.dp).size(24.dp)
                        )
                }
                Column(
                    modifier = Modifier.weight(0.80f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val popupTitle = stringResource(title)
                    MainText(
                        text = popupTitle,
                        initialFontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2
                    )
                }


            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val popupMessage = stringResource(message)
                MainText(
                    text = popupMessage,
                    color = Color.Black,
                    textAlign = TextAlign.Justify,
                    maxLines = Int.MAX_VALUE
                )
            }
            if (singleButton) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    horizontalArrangement = horizontalArrangementSingleButton
                ) {
                    TextButton(
                        modifier = Modifier
                            .semantics { contentDescription = "" },
                        onClick = onClick,
                    ) {
                        val popupTextButton = stringResource(textButton)
                        MainText(
                            text = popupTextButton,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            } else {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        modifier = Modifier
                            .semantics { contentDescription = "" },
                        onClick = onClickLeft,
                    ) {
                        val popupTextButtonLeft = stringResource(textButtonLeft)
                        MainText(
                            text = popupTextButtonLeft,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    TextButton(
                        modifier = Modifier
                            .semantics { contentDescription = "" },
                        onClick = onClickRight,
                    ) {
                        val popupTextButtonRight = stringResource(textButtonRight)
                        MainText(
                            text = popupTextButtonRight,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

                }
            }
        }
    }

}