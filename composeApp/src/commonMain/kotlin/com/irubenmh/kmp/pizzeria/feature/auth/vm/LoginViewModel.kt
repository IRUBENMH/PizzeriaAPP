package com.irubenmh.kmp.pizzeria.feature.auth.vm

import androidx.lifecycle.viewModelScope
import com.irubenmh.kmp.pizzeria.common.vm.BaseViewModel
import com.irubenmh.kmp.pizzeria.domain.repository.LoginRepository
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
) : BaseViewModel() {

    override val tag = "LoginViewModel"

    private val _username: MutableStateFlow<String> = MutableStateFlow("")
    val username: StateFlow<String> = _username.asStateFlow()

    private val _password: MutableStateFlow<String> = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    private val _isLoginEnabled: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoginEnabled: StateFlow<Boolean> = _isLoginEnabled.asStateFlow()

    private val _firebaseUser: MutableStateFlow<FirebaseUser?> = MutableStateFlow(null)
    val firebaseUser: StateFlow<FirebaseUser?> = _firebaseUser.asStateFlow()

    fun doLogin() {
        showLoading()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                loginRepository.doSignUp(_username.value, _password.value)
            } catch (e: Exception) {
                loginRepository.doSignIn(_username.value, _password.value)
            } finally {
                hideLoading()
            }
        }
    }

    fun setUsername(username: String) {
        println("$tag (setUsername): $username")
        _username.update { username  }
        isLoginEnabled()
    }

    fun setPassword(password: String) {
        println("$tag (setPassword): $password")
        _password.update { password }
        isLoginEnabled()
    }

    private fun isLoginEnabled() {
        _isLoginEnabled.update {
            username.value.isNotEmpty() && password.value.isNotEmpty()
        }
    }

}