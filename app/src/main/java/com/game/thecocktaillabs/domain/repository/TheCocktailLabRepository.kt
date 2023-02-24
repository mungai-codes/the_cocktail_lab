package com.game.thecocktaillabs.domain.repository

import com.game.thecocktaillabs.common.Resource
import com.game.thecocktaillabs.domain.model.Category
import com.game.thecocktaillabs.domain.model.Drink
import kotlinx.coroutines.flow.Flow


interface TheCocktailLabRepository {

    fun searchForCocktails(query: String): Flow<Resource<List<Drink>>>

    fun getCocktailCategories(): Flow<Resource<List<Category>>>

    fun searchCocktailsByCategory(category: String) : Flow<Resource<List<Drink>>>
}