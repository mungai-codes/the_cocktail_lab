package com.game.thecocktaillabs.data.remote

import com.game.thecocktaillabs.data.remote.response.CategoryResponse
import com.game.thecocktaillabs.data.remote.response.CategorySearchResponse
import com.game.thecocktaillabs.data.remote.response.CocktailSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TheCocktailDbApiService {

    @GET("search.php")
    suspend fun searchCoqTail(@Query("s") query: String): CocktailSearchResponse

    @GET("list.php?c=list")
    suspend fun getCocktailCategories(): CategoryResponse

    @GET("filter.php")
    suspend fun searchCocktailsByCategory(@Query("c") category: String): CategorySearchResponse


}