package com.levelupgamer.store.data.repository

import com.levelupgamer.store.data.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CartRepository {
    private val _cartItems = MutableStateFlow<Map<Product, Int>>(emptyMap())

    fun getCartItems(): Flow<Map<Product, Int>> {
        return _cartItems.asStateFlow()
    }

    suspend fun addToCart(product: Product) {
        val currentItems = _cartItems.value.toMutableMap()
        val currentQuantity = currentItems.getOrDefault(product, 0)
        currentItems[product] = currentQuantity + 1
        _cartItems.value = currentItems
    }

    suspend fun removeFromCart(product: Product) {
        val currentItems = _cartItems.value.toMutableMap()
        currentItems.remove(product)
        _cartItems.value = currentItems
    }

    suspend fun clearCart() {
        _cartItems.value = emptyMap()
    }
}
