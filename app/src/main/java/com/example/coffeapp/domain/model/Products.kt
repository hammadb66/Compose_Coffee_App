package com.example.coffeapp.domain.model

data class Products(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val image: Int,
    val quantity: Int? = 1
)