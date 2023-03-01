package com.mungai.thecocktaillabs.domain.repository

import com.mungai.thecocktaillabs.common.Resource
import com.mungai.thecocktaillabs.data.local.entity.FavouriteCocktailEntity
import com.mungai.thecocktaillabs.domain.model.Category
import com.mungai.thecocktaillabs.domain.model.Drink
import com.mungai.thecocktaillabs.domain.model.Filter
import com.mungai.thecocktaillabs.domain.model.Glass
import kotlinx.coroutines.flow.Flow


interface TheCocktailLabRepository {

    fun searchForCocktails(query: String): Flow<Resource<List<Drink>>>

    fun getCocktailCategories(): Flow<Resource<List<Category>>>

    fun searchCocktailsByCategory(category: String): Flow<Resource<List<Drink>>>

    fun getAlcoholFilters(): Flow<Resource<List<Filter>>>

    fun searchCocktailsByAlcoholFilter(filter: String): Flow<Resource<List<Drink>>>

    fun getGlassTypes(): Flow<Resource<List<Glass>>>

    fun searchCocktailsByGlassType(glassType: String): Flow<Resource<List<Drink>>>

    fun lookupCocktailDetailsById(cocktailId: String): Flow<Resource<List<Drink>>>

    suspend fun insertFavouriteCocktail(cocktail: Drink)

    suspend fun getFavouriteCocktails(): List<FavouriteCocktailEntity>

    suspend fun getCocktailById(idDrink: String): FavouriteCocktailEntity

    suspend fun deleteCocktail(cocktail: FavouriteCocktailEntity)

}