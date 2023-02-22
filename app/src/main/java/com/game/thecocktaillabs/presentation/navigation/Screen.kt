package com.game.thecocktaillabs.presentation.navigation

sealed class Screen(val route: String) {
    object HomeScreen : Screen(route = "home_screen")

    object FavouritesScreen : Screen(route = "favourites_screen")

    object SearchScreen : Screen(route = "search_screen")
}
