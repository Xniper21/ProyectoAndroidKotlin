package com.levelupgamer.store.ui.login

import com.levelupgamer.store.data.model.User

data class LoginUiState(
    val user: User? = null,
    val loginError: String? = null
)
