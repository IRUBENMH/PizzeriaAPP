package com.irubenmh.kmp.pizzeria.feature.auth.vm

import androidx.lifecycle.viewModelScope
import com.irubenmh.kmp.pizzeria.common.vm.BaseViewModel
import com.irubenmh.kmp.pizzeria.domain.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginRepository: LoginRepository
) : BaseViewModel() {

    override val tag = "LoginViewModel"

    private val _username: MutableStateFlow<String> = MutableStateFlow("")
    val username: StateFlow<String> = _username.asStateFlow()

    private val _password: MutableStateFlow<String> = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    fun doLogin() {
        showLoading()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                loginRepository.doLogin(username.value, password.value)
            } catch (e: Exception) {
                print("$tag (Error): ${e.message}")
            } finally {
                hideLoading()
            }
        }
    }

    fun setUsername(username: String) {
        _username.value = username
    }

    fun setPassword(password: String) {
        _password.value = password
    }


}