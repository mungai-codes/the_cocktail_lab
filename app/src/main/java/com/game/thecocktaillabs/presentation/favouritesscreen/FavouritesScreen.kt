package com.game.thecocktaillabs.presentation.favouritesscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.game.thecocktaillabs.presentation.cocktaildetailsscreen.components.IngredientImage
import com.game.thecocktaillabs.presentation.homescreen.FabButton
import com.game.thecocktaillabs.presentation.navigation.Screen

@Composable
fun FavouritesScreen(
    navController: NavController,
    viewModel: FavouritesViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()

    val state = viewModel.uiState.collectAsState().value

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
            contentPadding = PaddingValues(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            items(state.favouriteCocktails) { cocktail ->
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp),
                    elevation = 6.dp,
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Column(
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "name",
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily.SansSerif,
                                color = Color.Black
                            )
                            cocktail.strDrink?.let {
                                Text(
                                    text = it,
                                    textAlign = TextAlign.Center,
                                    fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }

                        Column(
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "category",
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily.SansSerif,
                                color = Color.Black
                            )
                            cocktail.strCategory?.let {
                                Text(
                                    text = it,
                                    textAlign = TextAlign.Center,
                                    fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }

                        cocktail.strDrinkThumb?.let {
                            IngredientImage(
                                url = it,
                                modifier = Modifier.weight(0.5f)
                            )
                        }
                    }
                }
            }
        }

    }
}
