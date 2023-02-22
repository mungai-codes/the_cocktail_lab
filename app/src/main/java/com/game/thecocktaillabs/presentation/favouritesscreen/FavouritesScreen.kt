package com.game.thecocktaillabs.presentation.favouritesscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.game.thecocktaillabs.presentation.homescreen.FabButton
import com.game.thecocktaillabs.presentation.navigation.Screen

@Composable
fun FavouritesScreen(navController: NavController) {

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FabButton(
                homeButtonClicked = { navController.navigate(Screen.HomeScreen.route) },
                favouritesButtonClicked = { navController.navigate(Screen.FavouritesScreen.route) },
                searchButtonClicked = { navController.navigate(Screen.SearchScreen.route) }
            )
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding())
        ) {

        }

    }
}