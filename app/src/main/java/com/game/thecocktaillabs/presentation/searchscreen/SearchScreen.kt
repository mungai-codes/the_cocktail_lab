package com.game.thecocktaillabs.presentation.searchscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import com.game.thecocktaillabs.presentation.homescreen.FabButton
import com.game.thecocktaillabs.presentation.navigation.Screen
import com.game.thecocktaillabs.presentation.ui.theme.TheCocktailLabsTheme

@Composable
fun SearchScreen(
    navController: NavController
) {

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(
                alcoholicSearch = {},
                nonAlcoholicSearch = {},
                normalSearch = {})
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

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(top = 16.dp)
            ) {

                items(
                    listOf(
                        "1",
                        "2",
                        "3",
                        "4",
                        "5",
                        "1",
                        "2",
                        "3",
                        "4",
                        "5",
                        "1",
                        "2",
                        "3",
                        "4",
                        "5",
                    )
                ) {
                    ResultItemCard()
                }

            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    TheCocktailLabsTheme {
        SearchScreen(navController = rememberNavController())
    }
}