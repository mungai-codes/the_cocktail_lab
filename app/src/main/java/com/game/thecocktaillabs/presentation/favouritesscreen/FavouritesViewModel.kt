package com.game.thecocktaillabs.presentation.favouritesscreen

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
class FavouritesViewModel @Inject constructor(
    private val repository: TheCocktailLabRepository,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _uiState = MutableStateFlow(FavouritesUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch(ioDispatcher) {
            _uiState.update { it.copy(favouriteCocktails = repository.getFavouriteCocktails()) }
        }
    }

    fun removeCocktailFromFavourites(idDrink: String) {
        viewModelScope.launch(ioDispatcher) {
            val cocktail = repository.getCocktailById(idDrink)
            repository.deleteCocktail(cocktail)
            _uiState.update { it.copy(favouriteCocktails = repository.getFavouriteCocktails()) }
        }
    }
}