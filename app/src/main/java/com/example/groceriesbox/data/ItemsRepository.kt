package com.example.groceriesbox.data

interface ItemsRepository {
    suspend fun getAllItems(): List<Item>
}