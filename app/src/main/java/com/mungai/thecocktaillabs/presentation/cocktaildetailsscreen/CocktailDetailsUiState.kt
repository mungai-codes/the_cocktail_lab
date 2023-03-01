package com.mungai.thecocktaillabs.presentation.cocktaildetailsscreen

import com.mungai.thecocktaillabs.domain.model.Drink

data class CocktailDetailsUiState(
    val drink: List<Drink> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)
