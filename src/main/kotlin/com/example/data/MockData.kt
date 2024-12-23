package com.example.data

import com.example.models.*

object MockData {
    private val profile = Profile(
        name = "John Doe",
        size = "L"
    )

    private val products = listOf(
        Product(
            id = "1",
            name = "T-Shirt",
            price = Price(29.99, "USD"),
            image = "https://example.com/tshirt.jpg"
        ),
        Product(
            id = "2",
            name = "Jeans",
            price = Price(59.99, "USD"),
            image = "https://example.com/jeans.jpg"
        )
    )

    private val stores = listOf(
        Store(
            id = "1",
            name = "Fashion Store",
            rating = Rating(4.5, 100),
            products = products
        ),
        Store(
            id = "2",
            name = "Trendy Shop",
            rating = Rating(4.8, 150),
            products = products
        )
    )

    private val storeLights = stores.map { store ->
        StoreLight(
            id = store.id,
            name = store.name,
            rating = store.rating
        )
    }

    val homeComponent = HomeComponent(
        filters = listOf(
            Filter("New"),
            Filter("Popular"),
            Filter("Sale")
        ),
        banner = Banner("1", "https://example.com/banner.jpg"),
        collections = listOf(
            Collection("1", "Summer Collection", storeLights),
            Collection("2", "Winter Collection", storeLights)
        ),
        storeCollections = listOf(
            StoreCollection("1", "Featured Stores", stores),
            StoreCollection("2", "Top Rated Stores", stores)
        )
    )

    fun getProfile() = profile
    fun getStore(id: String) = stores.find { it.id == id }

    fun updateProfile(name: String?, size: String?) {
        name?.let { profile.name = it }
        size?.let { profile.size = it }
    }
}