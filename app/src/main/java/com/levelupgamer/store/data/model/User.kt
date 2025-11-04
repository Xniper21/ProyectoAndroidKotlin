package com.levelupgamer.store.data.model

enum class UserRole {
    ADMIN,
    CUSTOMER
}

data class User(val username: String, val role: UserRole)
