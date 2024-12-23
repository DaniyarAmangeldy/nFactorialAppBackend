package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Price(
    val value: Double,
    val currency: String
)

@Serializable
data class Product(
    val id: String,
    val name: String,
    val price: Price,
    val image: String
)

@Serializable
data class Rating(
    val average: Double,
    val count: Int
)

@Serializable
data class Store(
    val id: String,
    val name: String,
    val rating: Rating,
    val image: String,
    val products: List<Product> = emptyList(),
)

@Serializable
data class StoreLight(
    val id: String,
    val name: String,
    val rating: Rating
)

@Serializable
data class Profile(
    var name: String,
    var size: String
)

@Serializable
data class ProfileUpdateRequest(
    val name: String?,
    val size: String?
)

@Serializable
data class Collection(
    val id: String,
    val name: String,
    val products: List<Product>
)

@Serializable
data class StoreCollection(
    val id: String,
    val name: String,
    val stores: List<Store>
)

@Serializable
data class Banner(
    val id: String,
    val image: String,
    val title: String,
    val description: String,
)

@Serializable
data class Filter(
    val id: String,
    val name: String
)

@Serializable
data class HomeComponent(
    val filters: List<Filter>,
    val banner: Banner,
    val collections: List<Collection>,
    val storeCollections: List<StoreCollection>
)