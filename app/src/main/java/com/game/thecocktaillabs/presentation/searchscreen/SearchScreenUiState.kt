package com.game.thecocktaillabs.presentation.searchscreen

import com.game.thecocktaillabs.domain.model.Drink

data class SearchScreenUiState(
    val drinks: List<Drink> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val query: String = ""
)