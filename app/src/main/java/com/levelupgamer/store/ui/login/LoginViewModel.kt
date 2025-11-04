package com.levelupgamer.store.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.levelupgamer.store.data.model.Credential
import com.levelupgamer.store.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(private val authRepository: AuthRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun login(credential: Credential) {
        viewModelScope.launch {
            val user = authRepository.login(credential)
            _uiState.update {
                if (user != null) {
                    it.copy(user = user, loginError = null)
                } else {
                    it.copy(user = null, loginError = "Invalid credentials")
                }
            }
        }
    }
}
