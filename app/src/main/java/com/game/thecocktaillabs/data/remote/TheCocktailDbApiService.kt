package com.game.thecocktaillabs.data.remote

import com.game.thecocktaillabs.data.remote.dto.CocktailSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TheCocktailDbApiService {

    @GET("search.php")
    suspend fun searchCoqTail(@Query("s") query: String): CocktailSearchResponse


}