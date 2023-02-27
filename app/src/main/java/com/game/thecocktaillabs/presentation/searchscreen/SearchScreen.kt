package com.game.thecocktaillabs.presentation.searchscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.game.thecocktaillabs.presentation.homescreen.FabButton
import com.game.thecocktaillabs.presentation.navigation.Screen
import com.game.thecocktaillabs.presentation.ui.theme.TheCocktailLabsTheme
import com.mungaicodes.tomesanctuary.util.UiEvent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchScreenViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()

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

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(
                categorySearch = viewModel::categorySearch,
                alcoholFilterSearch = viewModel::alcoholFilterSearch,
                glassTypeSearch = viewModel::glassTypeSearch,
                normalSearch = { viewModel.normalSearch() },
                query = state.query,
                categories = state.categories,
                filters = state.filters,
                glassTypes = state.glasses,
                onQueryChanged = viewModel::updateQuery,
                clearSearchQuery = viewModel::clearSearchQuery
            )
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
                .padding(top = innerPadding.calculateTopPadding()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Divider(
                thickness = 1.5.dp,
                color = MaterialTheme.colors.primary.copy(alpha = 0.5f)
            )

            if (state.isLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(top = 16.dp)
            ) {

                items(state.drinks) { cocktail ->
                    ResultItemCard(drink = cocktail) {
                        navController.navigate(route = Screen.DetailsScreen.route + "?cocktailId=${cocktail.idDrink}")
                    }
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