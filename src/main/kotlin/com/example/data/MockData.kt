package com.example.data

import com.example.models.*
import com.example.models.Collection

object MockData {
    private val profile = Profile(
        name = "Daniyar Amangeldi",
        size = "37"
    )

    private val stores = listOf(
        Store(
            id = "0",
            name = "Lamoda",
            image = "https://wbcon.ru/wp-content/uploads/2021/09/lamoda-1.png",
            rating = Rating(4.7, 2300),
        ),
        Store(
            id = "1",
            name = "Zara",
            image = "https://sp-ao.shortpixel.ai/client/to_webp,q_glossy,ret_img,w_750,h_400/https://assets.designhill.com/design-blog/wp-content/uploads/2019/01/1-6.jpg",
            rating = Rating(4.4, 21200),
            products = listOf(
                Product(
                    name = "Founds",
                    id = "1",
                    image = "https://a.lmcdn.ru/img600x866/R/T/RTLADJ687001_23960304_1_v1.jpg",
                    price = Price(45.0, "$"),
                ),
                Product(
                    name = "Demix",
                    id = "2",
                    image = "https://a.lmcdn.ru/img600x866/M/P/MP002XW179AI_24114653_1_v1.jpg",
                    price = Price(40.0, "$"),
                ),
                Product(
                    name = "Dino Ricci",
                    id = "3",
                    image = "https://a.lmcdn.ru/img600x866/M/P/MP002XW0OS4H_22090309_1_v1.jpg",
                    price = Price(38.0, "$"),
                ),
                Product(
                    name = "Adidas Originals",
                    id = "4",
                    image = "https://a.lmcdn.ru/img600x866/R/T/RTLACY244704_24361911_1_v3.jpg",
                    price = Price(100.0, "$"),
                ),
            )
        ),
        Store(
            id = "2",
            name = "Intertop",
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRdb5pD0n1FyyVnmbpwIVIXIRNVAZXF0-e6_A&s",
            rating = Rating(3.4, 500),
        ),
        Store(
            id = "3",
            name = "Adidas",
            image = "https://adidas.kz/og-image.jpg",
            rating = Rating(5.0, 23000),
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
            Filter("1", "Sandals"),
            Filter("2","Heels"),
            Filter("3","Shoes"),
            Filter("4","Slippers"),
            Filter("5","Boots"),
            Filter("6","Sneakers"),
            Filter("7","Loafers"),
            Filter("8","Oxfords"),
            Filter("9","Moccasins"),
            Filter("10","Flip-flops"),
        ),
        banner = Banner(
            "1",
            "https://i.pinimg.com/originals/57/e1/e6/57e1e681dbe970538c627164b301a540.jpg",
            title = "It's Time for\nPayday Sale!",
            description = "Up to 70% off!",
        ),
        collections = listOf(
            Collection(
                id = "1",
                name = "Trending Products",
                products = listOf(
                    Product(
                        name = "Founds",
                        id = "1",
                        image = "https://a.lmcdn.ru/img600x866/R/T/RTLADJ687001_23960304_1_v1.jpg",
                        price = Price(45.0, "$"),
                    ),
                    Product(
                        name = "Demix",
                        id = "2",
                        image = "https://a.lmcdn.ru/img600x866/M/P/MP002XW179AI_24114653_1_v1.jpg",
                        price = Price(40.0, "$"),
                    ),
                    Product(
                        name = "Dino Ricci",
                        id = "3",
                        image = "https://a.lmcdn.ru/img600x866/M/P/MP002XW0OS4H_22090309_1_v1.jpg",
                        price = Price(38.0, "$"),
                    ),
                    Product(
                        name = "Adidas Originals",
                        id = "4",
                        image = "https://a.lmcdn.ru/img600x866/R/T/RTLACY244704_24361911_1_v3.jpg",
                        price = Price(100.0, "$"),
                    )
                ),
            )
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