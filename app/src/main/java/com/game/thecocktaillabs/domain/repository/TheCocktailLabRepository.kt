package com.game.thecocktaillabs.domain.repository

import com.game.thecocktaillabs.common.Resource
import com.game.thecocktaillabs.domain.model.Category
import com.game.thecocktaillabs.domain.model.Drink
import com.game.thecocktaillabs.domain.model.Filter
import com.game.thecocktaillabs.domain.model.Glass
import kotlinx.coroutines.flow.Flow


interface TheCocktailLabRepository {

    fun searchForCocktails(query: String): Flow<Resource<List<Drink>>>

    fun getCocktailCategories(): Flow<Resource<List<Category>>>

    fun searchCocktailsByCategory(category: String): Flow<Resource<List<Drink>>>

    fun getAlcoholFilters(): Flow<Resource<List<Filter>>>

    fun searchCocktailsByAlcoholFilter(filter: String): Flow<Resource<List<Drink>>>

    fun getGlassTypes(): Flow<Resource<List<Glass>>>

    fun searchCocktailsByGlassType(glassType: String): Flow<Resource<List<Drink>>>

}