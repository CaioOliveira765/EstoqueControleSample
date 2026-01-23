package com.example.estoquesample.repository

import androidx.lifecycle.LiveData
import com.example.estoquesample.commons.dao.ProductDao
import com.example.estoquesample.commons.model.Product

class ProductRepository(private val dao: ProductDao) {
    val allProducts: LiveData<List<Product>> = dao.getAll()

    suspend fun insert(product: Product) = dao.insert(product)
    suspend fun update(product: Product) = dao.update(product)
    suspend fun delete(product: Product) = dao.delete(product)
}