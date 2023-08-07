package com.example.groceriesbox.data

data class Item(
    val id: String,
    val name: String,
    val price_in_eur: Float,
    val price_in_btc: Float,
    val price_in_satoshi: Int,
)