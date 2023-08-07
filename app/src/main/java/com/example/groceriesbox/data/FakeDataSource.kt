package com.example.groceriesbox.data

object FakeDataSource {
    private var id: String = "id"
    private var name: String = "name"
    private var price_in_eur: Float = 1f
    private var price_in_btc: Float = 1f
    private var price_in_satoshi: Int = 1

    val item = Item(id, name, price_in_eur, price_in_btc, price_in_satoshi)

    val listItems = listOf<Item>(
        Item("1", name = name+1, price_in_eur, price_in_btc, price_in_satoshi),
        Item("2", name = name+2, price_in_eur, price_in_btc, price_in_satoshi),
//        Item("3", name = name+3, price_in_eur, price_in_btc, price_in_satoshi)
    )

    val cart = Cart(listItems)
}

class FakeItemRepository() : ItemsRepository {
    override suspend fun getAllItems(): List<Item> {
        return FakeDataSource.listItems
    }
}

class FakeCartRepository() : CartRepository {
    override suspend fun getCart(): Cart {
        return FakeDataSource.cart
    }
}
