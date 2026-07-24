package com.example.coffeapp.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {
    @Serializable
    object WelcomeScreen : Routes()

    @Serializable
    object HomeScreen : Routes()

    @Serializable
    object CartScreen : Routes()

    @Serializable
    object FavoriteScreen : Routes()

    @Serializable
    object ProfileScreen : Routes()

    @Serializable
    data class DetailsScreen(val productId: Int) : Routes()

}