package com.game.thecocktaillabs.presentation.homescreen

data class HomeScreenUiState(
    val loading: Boolean = false,
    val error: String? = null,
    val query: String = ""
)
