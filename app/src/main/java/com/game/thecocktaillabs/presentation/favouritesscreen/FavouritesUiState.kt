package com.game.thecocktaillabs.presentation.favouritesscreen

import com.game.thecocktaillabs.data.local.entity.FavouriteCocktailEntity

data class FavouritesUiState(
    val favouriteCocktails: List<FavouriteCocktailEntity> = emptyList()
)