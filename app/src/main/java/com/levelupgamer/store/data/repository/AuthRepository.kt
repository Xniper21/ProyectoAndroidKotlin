package com.levelupgamer.store.data.repository

import com.levelupgamer.store.data.model.Credential
import com.levelupgamer.store.data.model.User
import com.levelupgamer.store.data.model.UserRole

class AuthRepository {
    fun login(credential: Credential): User? {
        return when {
            credential.email == "admin" && credential.pass == "admin" -> {
                User(credential.email, UserRole.ADMIN)
            }
            credential.email == "usuario1" && credential.pass == "usuario1" -> {
                User(credential.email, UserRole.CUSTOMER)
            }
            else -> null
        }
    }
}
