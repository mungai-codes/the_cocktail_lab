package com.game.thecocktaillabs.presentation.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.game.thecocktaillabs.di.IoDispatcher
import com.game.thecocktaillabs.domain.repository.TheCocktailLabRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: TheCocktailLabRepository,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadFavouriteCocktails()
    }

    private fun loadFavouriteCocktails() {
        viewModelScope.launch(ioDispatcher) {
            _uiState.update {
                it.copy(
                    favouriteCocktails = repository.getFavouriteCocktails()
                )
            }
        }
    }

    fun loadFeaturedCocktails() {

    }

    fun updateQuerry(input: String) {
        _uiState.update {
            it.copy(
                query = input
            )
        }
    }

}