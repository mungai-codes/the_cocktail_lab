package com.game.thecocktaillabs.presentation.searchscreen

import com.game.thecocktaillabs.domain.model.Category
import com.game.thecocktaillabs.domain.model.Drink
import com.game.thecocktaillabs.domain.model.Filter
import com.game.thecocktaillabs.domain.model.Glass

data class SearchScreenUiState(
    val drinks: List<Drink> = emptyList(),
    val categories: List<Category> = emptyList(),
    val filters: List<Filter> = emptyList(),
    val glasses: List<Glass> = emptyList(),
    val isLoading: Boolean = false,
    val loadingCategories: Boolean = false,
    val loadingGlassTypes: Boolean = false,
    val loadingFilters: Boolean = false,
    val error: String? = null,
    val query: String = ""
)