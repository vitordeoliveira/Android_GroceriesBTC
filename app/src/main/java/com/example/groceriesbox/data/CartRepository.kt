package com.example.groceriesbox.data

interface CartRepository {
    suspend fun getCart(): Cart
}