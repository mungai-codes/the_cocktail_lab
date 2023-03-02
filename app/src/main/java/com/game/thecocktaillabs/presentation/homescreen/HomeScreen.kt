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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.game.thecocktaillabs.presentation.homescreen.components.FabButton
import com.game.thecocktaillabs.presentation.homescreen.components.FavouriteCocktailCard
import com.game.thecocktaillabs.presentation.homescreen.components.FeaturedCocktail
import com.game.thecocktaillabs.presentation.homescreen.components.HomeScreenData
import com.game.thecocktaillabs.presentation.homescreen.components.TopBar
import com.game.thecocktaillabs.presentation.navigation.Screen
import com.game.thecocktaillabs.presentation.settingsdrawer.Settings
import com.game.thecocktaillabs.presentation.ui.theme.TheCocktailLabsTheme
import com.mungaicodes.tomesanctuary.util.UiEvent
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeScreenViewModel = hiltViewModel()) {

    val scaffoldState = rememberScaffoldState()

    val scope = rememberCoroutineScope()

    val state = viewModel.uiState.collectAsState().value

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }

    LaunchedEffect(key1 = true) {
        viewModel.loadFavouriteCocktails()
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(
                timeOfDay = state.timeOfDay,
                onSearchClicked = { query ->
                    navController.navigate(Screen.SearchScreen.route + "?query=${query}")
                }
            ) {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }
        },
        floatingActionButton = {
            FabButton(
                homeButtonClicked = { },
                favouritesButtonClicked = { navController.navigate(Screen.FavouritesScreen.route) },
                searchButtonClicked = { navController.navigate(Screen.SearchScreen.route) }
            )
        },
        //enable dragging only when the drawer is open
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            Settings()
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
                        data = state.featuredCocktails.shuffled().take(6),
                        title = "Featured Cocktails",
                        seeMore = {
                            navController.navigate(Screen.SearchScreen.route + "?query=${state.seeMoreQuery}")
                        }
                    ) { cocktail ->
                        FeaturedCocktail(
                            drink = cocktail,
                        ) {
                            navController.navigate(route = Screen.DetailsScreen.route + "?cocktailId=${cocktail.idDrink}")
                        }
                    }
                }

                item {
                    if (state.favouriteCocktails.isEmpty()) {
                        HomeScreenData(
                            data = state.featuredCocktails.shuffled().take(6),
                            title = "More Featured Cocktails",
                            seeMore = {
                                navController.navigate(Screen.SearchScreen.route + "?query=${state.seeMoreQuery}")
                            }
                        ) { cocktail ->
                            FeaturedCocktail(
                                drink = cocktail,
                            ) {
                                navController.navigate(route = Screen.DetailsScreen.route + "?cocktailId=${cocktail.idDrink}")
                            }
                        }
                    } else {
                        HomeScreenData(
                            data = state.favouriteCocktails,
                            title = "Your Cocktails",
                            seeMore = {
                                navController.navigate(route = Screen.FavouritesScreen.route)
                            }
                        ) { cocktail ->
                            FavouriteCocktailCard(drink = cocktail) {
                                navController.navigate(route = Screen.DetailsScreen.route + "?cocktailId=${cocktail.idDrink}")
                            }
                        }
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