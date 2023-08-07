package com.example.groceriesbox.data

data class Cart(
    val items: List<Item> = emptyList(),
    val total_price_in_eur: Float = 0f,
    val total_price_in_btc: Float = 0f,
    val total_price_in_satoshi: Int = 0,
)
