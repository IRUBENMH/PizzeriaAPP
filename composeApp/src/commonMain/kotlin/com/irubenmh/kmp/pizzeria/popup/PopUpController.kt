package com.irubenmh.kmp.pizzeria.popup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.irubenmh.kmp.pizzeria.common.vm.BaseViewModel

@Composable
fun PopUpController(viewModel: BaseViewModel) {
    val popUp by viewModel.popup.collectAsStateWithLifecycle()
    when(popUp) {

        else -> {}
    }
}