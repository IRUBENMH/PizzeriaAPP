package com.irubenmh.kmp.pizzeria.common.vm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

open class BaseViewModel : ViewModel() {
    open val tag = "BaseViewModel"

    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loading : StateFlow<Boolean> = _loading.asStateFlow()

    private val _popup: MutableStateFlow<String> = MutableStateFlow("")
    val popup : StateFlow<String> = _popup.asStateFlow()

    fun showLoading() {
        _loading.update { true }
    }

    fun hideLoading() {
        _loading.update { false }
    }

    fun showPopup(popup: String) {
        _popup.update { popup }
    }

    fun hidePopup() {
        _popup.update { "" }

    }

}