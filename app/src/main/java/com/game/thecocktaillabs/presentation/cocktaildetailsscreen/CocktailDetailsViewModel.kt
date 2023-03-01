package com.game.thecocktaillabs.presentation.cocktaildetailsscreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.game.thecocktaillabs.common.Resource
import com.game.thecocktaillabs.di.IoDispatcher
import com.game.thecocktaillabs.domain.model.Drink
import com.game.thecocktaillabs.domain.repository.TheCocktailLabRepository
import com.mungaicodes.tomesanctuary.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CocktailDetailsViewModel @Inject constructor(
    private val repository: TheCocktailLabRepository,
    savedStateHandle: SavedStateHandle,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _uiState = MutableStateFlow(CocktailDetailsUiState())
    val uiState = _uiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        savedStateHandle.get<String>("cocktailId")?.let { cocktailId ->
            viewModelScope.launch {
                repository.lookupCocktailDetailsById(cocktailId = cocktailId).onEach { result ->
                    when (result) {
                        is Resource.Loading -> {
                            _uiState.update { it.copy(loading = true) }
                        }

                        is Resource.Success -> {
                            _uiState.update {
                                it.copy(
                                    loading = false,
                                    drink = result.data ?: emptyList()
                                )
                            }
                        }

                        is Resource.Error -> {
                            _uiState.update {
                                it.copy(
                                    loading = false,
                                    error = result.message
                                )
                            }
                            _eventFlow.emit(UiEvent.ShowSnackBar(message = _uiState.value.error!!))
                        }
                    }
                }.launchIn(this)
            }
            checkIfInFavourites(cocktailId)
        }
    }

    fun addCocktailToFavourites(cocktail: Drink) {
        viewModelScope.launch(ioDispatcher) {
            repository.insertFavouriteCocktail(cocktail)
            cocktail.idDrink?.let { checkIfInFavourites(it) }
        }
    }

    fun removeCocktailFromFavourites(idDrink: String) {
        viewModelScope.launch(ioDispatcher) {
            val cocktail = repository.getCocktailById(idDrink)
            repository.deleteCocktail(cocktail)
            checkIfInFavourites(idDrink)
        }
    }

    private fun checkIfInFavourites(idDrink: String) {
        viewModelScope.launch(ioDispatcher) {
            val favouriteCocktails = repository.getFavouriteCocktails()
            val cocktail = repository.getCocktailById(idDrink)
            if (favouriteCocktails.contains(cocktail)) {
                _uiState.update { it.copy(isLiked = true) }
            } else {
                _uiState.update { it.copy(isLiked = false) }
            }
        }
    }
}