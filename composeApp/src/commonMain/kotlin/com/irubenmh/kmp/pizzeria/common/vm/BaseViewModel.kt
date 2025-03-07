package com.irubenmh.kmp.pizzeria.common.vm

import androidx.lifecycle.ViewModel
import com.irubenmh.kmp.pizzeria.error.data.model.BaseErrorState
import com.irubenmh.kmp.pizzeria.error.data.model.Error
import com.irubenmh.kmp.pizzeria.error.data.model.ErrorStateMapper
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.coroutines.CoroutineContext

open class BaseViewModel(errorStateMapper: ErrorStateMapper) : ViewModel() {

    open val tag = "BaseViewModel"

    private val baseErrorStateMapper = errorStateMapper

    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loading : StateFlow<Boolean> = _loading.asStateFlow()

    private val _popup: MutableStateFlow<String> = MutableStateFlow("")
    val popup : StateFlow<String> = _popup.asStateFlow()

    private val _error: MutableStateFlow<Error> = MutableStateFlow(Error(BaseErrorState.NO_ERROR))
    val error: StateFlow<Error> = _error.asStateFlow()

    private fun exceptionHandler(doOnFailure: (Throwable) -> Unit = {}) = CoroutineExceptionHandler { _, t ->
        handleErrorState(t)
        doOnFailure(t)
    }

    protected fun context(
        context: CoroutineContext = Dispatchers.IO,
        doOnFailure: (Throwable) -> Unit = {}
    ) = context + exceptionHandler(doOnFailure)

    fun showLoading() {
        _loading.update { true }
    }

    fun hideLoading() {
        _loading.update { false }
    }

    fun handleErrorState(t: Throwable) {
        t.printStackTrace()
        _error.value = Error(baseErrorStateMapper.map(t))
    }

    fun clearErrorState() {
        _error.value =Error(BaseErrorState.NO_ERROR)
    }

    fun showPopup(popup: String) {
        _popup.update { popup }
    }

    fun hidePopup() {
        _popup.update { "" }

    }

}