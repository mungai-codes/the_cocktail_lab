package com.game.thecocktaillabs.presentation.cocktaildetailsscreen

import com.game.thecocktaillabs.domain.model.Drink

data class CocktailDetailsUiState(
    val drink: List<Drink> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val isLiked: Boolean = false
)
