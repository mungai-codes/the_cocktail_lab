package com.game.thecocktaillabs.domain.repository

import com.game.thecocktaillabs.common.Resource
import com.game.thecocktaillabs.domain.model.Drink
import kotlinx.coroutines.flow.Flow


interface TheCocktailLabRepository {

    fun searchForCocktails(query: String): Flow<Resource<List<Drink>>>
}