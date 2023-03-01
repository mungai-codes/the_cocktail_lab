package com.mungai.thecocktaillabs.presentation.searchscreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mungai.thecocktaillabs.common.Resource
import com.mungai.thecocktaillabs.di.IoDispatcher
import com.mungai.thecocktaillabs.domain.repository.TheCocktailLabRepository
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
    private val ioDispatcher: CoroutineDispatcher,
    savedStateHandle: SavedStateHandle
) : ViewModel() {


    private val _uiState = MutableStateFlow(SearchScreenUiState())
    val uiState = _uiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var searchJob: Job? = null

    init {
        loadCategories()
        loadFilters()
        loadGlassTypes()
        savedStateHandle.get<String>("query")?.let { query ->
            if (query != "blank") {
                viewModelScope.launch {
                    _uiState.update { it.copy(query = query) }
                    normalSearch()
                }
            }
        }
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

    fun alcoholFilterSearch(filter: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            repository.searchCocktailsByAlcoholFilter(filter).onEach { result ->
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

    fun glassTypeSearch(glassType: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            repository.searchCocktailsByGlassType(glassType).onEach { result ->
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

    private fun loadFilters() {
        viewModelScope.launch(ioDispatcher) {
            repository.getAlcoholFilters().onEach { result ->
                when (result) {
                    is Resource.Loading -> {
                        _uiState.update { it.copy(loadingFilters = true) }
                    }

                    is Resource.Success -> {
                        _uiState.update {
                            it.copy(
                                loadingFilters = false,
                                filters = result.data ?: emptyList()
                            )
                        }
                    }

                    is Resource.Error -> {
                        _uiState.update {
                            it.copy(
                                loadingFilters = false,
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

    private fun loadGlassTypes() {
        viewModelScope.launch(ioDispatcher) {
            repository.getGlassTypes().onEach { result ->
                when (result) {
                    is Resource.Loading -> {
                        _uiState.update { it.copy(loadingGlassTypes = true) }
                    }

                    is Resource.Success -> {
                        _uiState.update {
                            it.copy(
                                loadingGlassTypes = false,
                                glasses = result.data ?: emptyList()
                            )
                        }
                    }

                    is Resource.Error -> {
                        _uiState.update {
                            it.copy(
                                loadingGlassTypes = false,
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