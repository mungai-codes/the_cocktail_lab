package com.mungai.thecocktaillabs.presentation.favouritesscreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mungai.thecocktaillabs.presentation.homescreen.FabButton
import com.mungai.thecocktaillabs.presentation.navigation.Screen

@Composable
fun FavouritesScreen(navController: NavController) {

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FabButton(
                homeButtonClicked = { navController.navigate(Screen.HomeScreen.route) },
                favouritesButtonClicked = { },
                searchButtonClicked = { navController.navigate(Screen.SearchScreen.route) }
            )
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding()),
            contentPadding = PaddingValues(top = 16.dp)
        ) {

        }
    }
}