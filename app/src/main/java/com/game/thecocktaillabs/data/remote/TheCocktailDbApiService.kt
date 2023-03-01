package com.game.thecocktaillabs.data.remote

import com.game.thecocktaillabs.data.remote.response.AlcoholFilterSearchResponse
import com.game.thecocktaillabs.data.remote.response.CategoryResponse
import com.game.thecocktaillabs.data.remote.response.CategorySearchResponse
import com.game.thecocktaillabs.data.remote.response.FilterResponse
import com.game.thecocktaillabs.data.remote.response.GlassResponse
import com.game.thecocktaillabs.data.remote.response.GlassTypeSearchResponse
import com.game.thecocktaillabs.data.remote.response.MainResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TheCocktailDbApiService {

    @GET("search.php")
    suspend fun searchCoqTail(@Query("s") query: String): MainResponse

    @GET("list.php?c=list")
    suspend fun getCocktailCategories(): CategoryResponse

    @GET("filter.php")
    suspend fun searchCocktailsByCategory(@Query("c") category: String): CategorySearchResponse

    @GET("list.php?g=list")
    suspend fun getGlassTypes(): GlassResponse

    @GET("filter.php")
    suspend fun searchCocktailByGlassType(@Query("g") glassType: String): GlassTypeSearchResponse

    @GET("list.php?a=list")
    suspend fun getAlcoholFilters(): FilterResponse

    @GET("filter.php")
    suspend fun searchCocktailsByAlcoholFilter(@Query("a") filter: String): AlcoholFilterSearchResponse

    @GET("lookup.php")
    suspend fun lookupCocktailDetailsById(@Query("i") cocktailId: String) : MainResponse
}