package com.game.thecocktaillabs.presentation.homescreen

import com.game.thecocktaillabs.data.local.entity.FavouriteCocktailEntity
import com.game.thecocktaillabs.domain.model.Drink

data class HomeScreenUiState(
    val favouriteCocktails: List<FavouriteCocktailEntity> = emptyList(),
    val featuredCocktails: List<Drink> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val seeMoreQuery: String = ""
)
