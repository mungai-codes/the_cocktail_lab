package com.mungai.thecocktaillabs.presentation.searchscreen

import com.mungai.thecocktaillabs.domain.model.Category
import com.mungai.thecocktaillabs.domain.model.Drink
import com.mungai.thecocktaillabs.domain.model.Filter
import com.mungai.thecocktaillabs.domain.model.Glass

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