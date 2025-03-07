package com.irubenmh.kmp.pizzeria.feature.auth.vm

import androidx.lifecycle.viewModelScope
import com.irubenmh.kmp.pizzeria.common.vm.BaseViewModel
import com.irubenmh.kmp.pizzeria.domain.repository.LoginRepository
import com.irubenmh.kmp.pizzeria.error.data.model.BaseErrorStateMapper
import dev.gitlive.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginRepository: LoginRepository
) : BaseViewModel(BaseErrorStateMapper()) {

    override val tag = "LoginViewModel"

    private val _username: MutableStateFlow<String> = MutableStateFlow("")
    val username: StateFlow<String> = _username.asStateFlow()

    private val _password: MutableStateFlow<String> = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    private val _isLoginEnabled: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoginEnabled: StateFlow<Boolean> = _isLoginEnabled.asStateFlow()

    private val _firebaseUser: MutableStateFlow<FirebaseUser?> = MutableStateFlow(null)
    val firebaseUser: StateFlow<FirebaseUser?> = _firebaseUser.asStateFlow()

    fun doLogin(onFinally: () -> Unit) {
        showLoading()
        viewModelScope.launch(context(Dispatchers.Main)) {
            try {
                _firebaseUser.value = loginRepository.doSignIn(_username.value, _password.value)?.user
                println("$tag (doLogin): ${_firebaseUser.value ?: "Sin usuario"}")
                onFinally()
            } finally {
                hideLoading()
            }
        }
    }

    fun isLoginEnabled() : Boolean = _username.value.isNotEmpty() && _password.value.length >= 6

    fun setUsername(username: String) {
        println("$tag (setUsername): $username")
        _username.update { username  }
    }

    fun setPassword(password: String) {
        println("$tag (setPassword): $password")
        _password.update { password }
    }



}