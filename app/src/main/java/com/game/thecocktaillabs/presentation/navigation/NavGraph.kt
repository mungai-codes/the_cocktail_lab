package com.game.thecocktaillabs.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.game.thecocktaillabs.presentation.cocktaildetailsscreen.CocktailDetailsScreen
import com.game.thecocktaillabs.presentation.favouritesscreen.FavouritesScreen
import com.game.thecocktaillabs.presentation.homescreen.HomeScreen
import com.game.thecocktaillabs.presentation.searchscreen.SearchScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.FavouritesScreen.route) {
            FavouritesScreen(navController = navController)
        }
        composable(route = Screen.SearchScreen.route) {
            SearchScreen(navController = navController)
        }
        composable(
            route = Screen.DetailsScreen.route + "?cocktailId={cocktailId}",
            arguments = listOf(
                navArgument(name = "cocktailId") {
                    type = NavType.StringType
                }
            )) {
            CocktailDetailsScreen(navController = navController)
        }
    }
}