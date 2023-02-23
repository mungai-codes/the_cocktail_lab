package com.game.thecocktaillabs.data.repository

import com.game.thecocktaillabs.common.Resource
import com.game.thecocktaillabs.common.toDrink
import com.game.thecocktaillabs.data.local.TheCocktailLabDatabase
import com.game.thecocktaillabs.data.remote.TheCocktailDbApiService
import com.game.thecocktaillabs.domain.model.Drink
import com.game.thecocktaillabs.domain.repository.TheCocktailLabRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class TheCocktailLabRepositoryImpl @Inject constructor(
    private val apiService: TheCocktailDbApiService,
    database: TheCocktailLabDatabase
) : TheCocktailLabRepository {
    override fun searchForCocktails(query: String): Flow<Resource<List<Drink>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val result = apiService.searchCoqTail(query).drinks.map { it.toDrink() }
                emit(Resource.Success(result))
            } catch (e: HttpException) {
                emit(Resource.Error(message = e.message()))
            } catch (e: IOException) {
                emit(Resource.Error(message = e.localizedMessage))
            }
        }
    }
}