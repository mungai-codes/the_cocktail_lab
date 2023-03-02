package com.game.thecocktaillabs.presentation.homescreen

import android.icu.util.Calendar
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.game.thecocktaillabs.common.Resource
import com.game.thecocktaillabs.di.IoDispatcher
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
class HomeScreenViewModel @Inject constructor(
    private val repository: TheCocktailLabRepository,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState = _uiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        loadFavouriteCocktails()
        loadFeaturedCocktails()
        getTimeOfDay()
    }

    private fun getTimeOfDay() {
        val calendar = Calendar.getInstance()
        when (calendar.get(Calendar.HOUR_OF_DAY)) {
            in 6 until 12 -> _uiState.update { it.copy(timeOfDay = "morning") }
            in 12 until 17 -> _uiState.update { it.copy(timeOfDay = "afternoon") }
            in 17 until 21 -> _uiState.update { it.copy(timeOfDay = "evening") }
            else -> _uiState.update { it.copy(timeOfDay = "night") }
        }
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

    private fun loadFeaturedCocktails() {
        viewModelScope.launch {
            repository.searchForCocktails("").onEach { result ->
                when (result) {
                    is Resource.Loading -> {
                        _uiState.update { it.copy(isLoading = true) }
                    }

                    is Resource.Success -> {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                featuredCocktails = result.data ?: emptyList()
                            )
                        }
                    }

                    is Resource.Error -> {
                        _uiState.update { it.copy(isLoading = false, error = result.message) }
                        _eventFlow.emit(
                            UiEvent.ShowSnackBar(
                                _uiState.value.error ?: "An unexpected error occurred"
                            )
                        )
                    }
                }
            }.launchIn(this)
        }
    }


}