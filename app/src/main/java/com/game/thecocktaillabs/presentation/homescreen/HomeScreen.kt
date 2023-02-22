package com.game.thecocktaillabs.presentation.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.game.thecocktaillabs.presentation.navigation.Screen
import com.game.thecocktaillabs.presentation.ui.theme.TheCocktailLabsTheme

@Composable
fun HomeScreen(navController: NavController) {

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar()
        },
        floatingActionButton = {
            FabButton(
                homeButtonClicked = { navController.navigate(Screen.HomeScreen.route) },
                favouritesButtonClicked = { navController.navigate(Screen.FavouritesScreen.route) },
                searchButtonClicked = { navController.navigate(Screen.SearchScreen.route) }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding())
        ) {
            Divider(
                thickness = 1.5.dp,
                color = MaterialTheme.colors.primary.copy(alpha = 0.5f)
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = innerPadding.calculateBottomPadding()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                item {

                }

                item {
                    HomeScreenData(
                        data = listOf("1", "2", "3", "4", "5"),
                        title = "Featured Cocktails",
                        seeMore = { /*TODO*/ }
                    ) {
                        ItemCard()
                    }
                }

                item {
                    HomeScreenData(
                        data = listOf("1", "2", "3", "4", "5"),
                        title = "Your Cocktails",
                        seeMore = { /*TODO*/ }
                    ) {
                        ItemCard()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    TheCocktailLabsTheme {
        HomeScreen(rememberNavController())
    }
}