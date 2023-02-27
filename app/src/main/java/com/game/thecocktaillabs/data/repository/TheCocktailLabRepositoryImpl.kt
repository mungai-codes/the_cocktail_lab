package com.game.thecocktaillabs.data.repository

import com.game.thecocktaillabs.common.Resource
import com.game.thecocktaillabs.common.toDrink
import com.game.thecocktaillabs.data.local.TheCocktailLabDatabase
import com.game.thecocktaillabs.data.remote.TheCocktailDbApiService
import com.game.thecocktaillabs.domain.model.Category
import com.game.thecocktaillabs.domain.model.Drink
import com.game.thecocktaillabs.domain.model.Filter
import com.game.thecocktaillabs.domain.model.Glass
import com.game.thecocktaillabs.domain.repository.TheCocktailLabRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class TheCocktailLabRepositoryImpl @Inject constructor(
    private val apiService: TheCocktailDbApiService,
    database: TheCocktailLabDatabase
) : TheCocktailLabRepository {

    private val dao = database.dao

    override fun searchForCocktails(
        query: String
    ): Flow<Resource<List<Drink>>> {
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
        }.catch { e ->
            e.printStackTrace()
            emit(Resource.Error(message = "$query does not exist, check your spelling and try again."))
        }
    }

    override fun getCocktailCategories(): Flow<Resource<List<Category>>> {
        return flow {
            emit(Resource.Loading())

            val localCategories = dao.getCocktailCategories()

            if (localCategories.isEmpty()) {
                try {
                    val response =
                        apiService.getCocktailCategories().drinks.map { it.toCategoryEntity() }
                    dao.insertCocktailCategories(response)
                    emit(Resource.Success(data = response.map { it.toCategory() }))
                } catch (e: IOException) {
                    e.printStackTrace()
                    emit(Resource.Error(message = e.localizedMessage))
                } catch (e: HttpException) {
                    e.printStackTrace()
                    emit(Resource.Error(message = e.message()))
                }
            } else {
                emit(Resource.Success(data = localCategories.map { it.toCategory() }))
            }
        }.catch { e ->
            e.printStackTrace()
            emit(Resource.Error(message = e.localizedMessage))
        }
    }

    override fun searchCocktailsByCategory(category: String): Flow<Resource<List<Drink>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val result =
                    apiService.searchCocktailsByCategory(category).drinks.map { it.toDrink() }
                emit(Resource.Success(result))
            } catch (e: HttpException) {
                emit(Resource.Error(message = e.message()))
            } catch (e: IOException) {
                emit(Resource.Error(message = e.localizedMessage))
            }
        }.catch { e ->
            e.printStackTrace()
            emit(Resource.Error(message = "$category category does not exist!!"))
        }
    }

    override fun getAlcoholFilters(): Flow<Resource<List<Filter>>> {
        return flow {
            emit(Resource.Loading())

            val localFilters = dao.getAlcoholFilters()

            if (localFilters.isEmpty()) {
                try {
                    val response =
                        apiService.getAlcoholFilters().drinks.map { it.toFilterEntity() }
                    dao.insertAlcoholFilters(response)
                    emit(Resource.Success(data = response.map { it.toFilter() }))
                } catch (e: IOException) {
                    e.printStackTrace()
                    emit(Resource.Error(message = e.localizedMessage))
                } catch (e: HttpException) {
                    e.printStackTrace()
                    emit(Resource.Error(message = e.message()))
                }
            } else {
                emit(Resource.Success(data = localFilters.map { it.toFilter() }))
            }
        }.catch { e ->
            e.printStackTrace()
            emit(Resource.Error(message = e.localizedMessage))
        }
    }

    override fun searchCocktailsByAlcoholFilter(filter: String): Flow<Resource<List<Drink>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val result =
                    apiService.searchCocktailsByAlcoholFilter(filter).drinks.map { it.toDrink() }
                emit(Resource.Success(result))
            } catch (e: HttpException) {
                emit(Resource.Error(message = e.message()))
            } catch (e: IOException) {
                emit(Resource.Error(message = e.localizedMessage))
            }
        }.catch { e ->
            e.printStackTrace()
            emit(Resource.Error(message = "This $filter filter is not available."))
        }
    }

    override fun getGlassTypes(): Flow<Resource<List<Glass>>> {
        return flow {
            emit(Resource.Loading())

            val localFilters = dao.getGlassTypes()

            if (localFilters.isEmpty()) {
                try {
                    val response =
                        apiService.getGlassTypes().drinks.map { it.toGlassEntity() }
                    dao.insertGlassTypes(response)
                    emit(Resource.Success(data = response.map { it.toGlass() }))
                } catch (e: IOException) {
                    e.printStackTrace()
                    emit(Resource.Error(message = e.localizedMessage))
                } catch (e: HttpException) {
                    e.printStackTrace()
                    emit(Resource.Error(message = e.message()))
                }
            } else {
                emit(Resource.Success(data = localFilters.map { it.toGlass() }))
            }
        }.catch { e ->
            e.printStackTrace()
            emit(Resource.Error(message = e.localizedMessage))
        }
    }

    override fun searchCocktailsByGlassType(glassType: String): Flow<Resource<List<Drink>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val result =
                    apiService.searchCocktailByGlassType(glassType).drinks.map { it.toDrink() }
                emit(Resource.Success(result))
            } catch (e: HttpException) {
                emit(Resource.Error(message = e.message()))
            } catch (e: IOException) {
                emit(Resource.Error(message = e.localizedMessage))
            }
        }.catch { e ->
            e.printStackTrace()
            emit(Resource.Error(message = "This $glassType glass type is not available."))
        }
    }

    override fun lookupCocktailDetailsById(cocktailId: String): Flow<Resource<List<Drink>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val response =
                    apiService.lookupCocktailDetailsById(cocktailId).drinks.map { it.toDrink() }
                emit(Resource.Success(response))
            } catch (e: HttpException) {
                emit(Resource.Error(message = e.message()))
            } catch (e: IOException) {
                emit(Resource.Error(message = e.localizedMessage))
            }
        }.catch { e ->
            e.printStackTrace()
            emit(Resource.Error(message = "an ${e.message} error occurred"))
        }
    }


}