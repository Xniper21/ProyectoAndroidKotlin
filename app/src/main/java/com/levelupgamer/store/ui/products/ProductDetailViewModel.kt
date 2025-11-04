package com.levelupgamer.store.ui.products

import androidx.lifecycle.ViewModel
import com.levelupgamer.store.data.model.Product
import com.levelupgamer.store.data.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductDetailViewModel : ViewModel() { // Factory no longer needed

    private val productRepository = ProductRepository()

    private val _product = MutableStateFlow<Product?>(null)
    val product: StateFlow<Product?> = _product.asStateFlow()

    fun loadProduct(productId: Int) {
        // This synchronous call is fine for a simple, hardcoded repository
        _product.value = productRepository.getAllProducts().find { it.id == productId }
    }
}
