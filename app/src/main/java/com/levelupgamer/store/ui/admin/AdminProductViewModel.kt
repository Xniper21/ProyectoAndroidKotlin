package com.levelupgamer.store.ui.admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.levelupgamer.store.data.model.Product
import com.levelupgamer.store.data.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AdminProductViewModel : ViewModel() {

    private val productRepository = ProductRepository()

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products.asStateFlow()

    init {
        loadProducts()
    }

    private fun loadProducts() {
        _products.value = productRepository.getAllProducts() // Corrected function name
    }

    fun addProduct(product: Product) {
        // In a real app, you would save this to a database or network source
        val currentList = _products.value.toMutableList()
        currentList.add(product)
        _products.value = currentList
    }

    fun updateProduct(product: Product) {
        val currentList = _products.value.toMutableList()
        val index = currentList.indexOfFirst { it.id == product.id }
        if (index != -1) {
            currentList[index] = product
            _products.value = currentList
        }
    }

    fun deleteProduct(productId: Int) {
        val currentList = _products.value.toMutableList()
        currentList.removeAll { it.id == productId }
        _products.value = currentList
    }

    fun getProductById(productId: Int): Product? {
        return _products.value.find { it.id == productId }
    }
}
