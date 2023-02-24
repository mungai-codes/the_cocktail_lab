package com.game.thecocktaillabs.presentation.searchscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.game.thecocktaillabs.common.Resource
import com.game.thecocktaillabs.di.IoDispatcher
import com.game.thecocktaillabs.domain.repository.TheCocktailLabRepository
import com.mungaicodes.tomesanctuary.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Job
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
class SearchScreenViewModel @Inject constructor(
    private val repository: TheCocktailLabRepository,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {


    private val _uiState = MutableStateFlow(SearchScreenUiState())
    val uiState = _uiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var searchJob: Job? = null

    init {
        loadCategories()
    }

    fun normalSearch() {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            repository.searchForCocktails(_uiState.value.query.trim())
                .onEach { result ->
                    when (result) {
                        is Resource.Loading -> {
                            _uiState.update { it.copy(isLoading = true) }
                        }

                        is Resource.Success -> {
                            _uiState.update {
                                it.copy(
                                    isLoading = false,
                                    drinks = result.data ?: emptyList()
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
    fun categorySearch(category: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            repository.searchCocktailsByCategory(category).onEach { result ->
                when (result) {
                    is Resource.Loading -> {
                        _uiState.update { it.copy(isLoading = true) }
                    }

                    is Resource.Success -> {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                drinks = result.data ?: emptyList()
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

    private fun loadCategories() {
        viewModelScope.launch(ioDispatcher) {
            repository.getCocktailCategories().onEach { result ->
                when (result) {
                    is Resource.Loading -> {
                        _uiState.update { it.copy(loadingCategories = true) }
                    }

                    is Resource.Success -> {
                        _uiState.update {
                            it.copy(
                                loadingCategories = false,
                                categories = result.data ?: emptyList()
                            )
                        }
                    }

                    is Resource.Error -> {
                        _uiState.update {
                            it.copy(
                                loadingCategories = false,
                                error = result.message
                            )
                        }
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

    fun updateQuery(input: String) {
        _uiState.update { it.copy(query = input) }
    }

    fun clearSearchQuery() {
        _uiState.update { it.copy(query = "") }
    }


}