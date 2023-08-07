package com.example.groceriesbox.data


/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val itemsRepository: ItemsRepository
    val cartRepository: CartRepository
}

class AppDataContainer() : AppContainer {
    /**
     * Implementation for Repository
     */
    override val itemsRepository: ItemsRepository = FakeItemRepository()
    override val cartRepository: CartRepository = FakeCartRepository()
}