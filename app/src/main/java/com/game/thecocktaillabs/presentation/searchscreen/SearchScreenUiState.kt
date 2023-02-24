package com.game.thecocktaillabs.presentation.searchscreen

import com.game.thecocktaillabs.domain.model.Category
import com.game.thecocktaillabs.domain.model.Drink

data class SearchScreenUiState(
    val drinks: List<Drink> = emptyList(),
    val categories: List<Category> = emptyList(),
    val isLoading: Boolean = false,
    val loadingCategories: Boolean = false,
    val error: String? = null,
    val query: String = ""
)