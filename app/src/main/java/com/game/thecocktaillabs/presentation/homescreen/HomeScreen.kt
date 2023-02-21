package com.game.thecocktaillabs.presentation.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.game.thecocktaillabs.presentation.ui.theme.TheCocktailLabsTheme

@Composable
fun HomeScreen() {

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar()
        },
        floatingActionButton = {
            FabButton(
                homeButtonClicked = { /*TODO*/ },
                favouritesButtonClicked = { /*TODO*/ },
                searchButtonClicked = { /*ToDo*/ }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding())
        ) {
            Divider(
                thickness = 2.dp,
                modifier = Modifier
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                item {
                    LazyRow() {

                    }
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
        HomeScreen()
    }
}