package com.game.thecocktaillabs.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.game.thecocktaillabs.data.local.entity.CategoryEntity
import com.game.thecocktaillabs.data.local.entity.FilterEntity
import com.game.thecocktaillabs.data.local.entity.GlassEntity

@Dao
interface TheCockTailLabDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCocktailCategories(
        categoryEntity: List<CategoryEntity>
    )

    @Query("SELECT * from cocktail_categories")
    fun getCocktailCategories(): List<CategoryEntity>

    @Query("DELETE from cocktail_categories")
    suspend fun clearCocktailCategories()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlcoholFilters(
        filterEntity: List<FilterEntity>
    )

    @Query("SELECT * from alcohol_filters")
    fun getAlcoholFilters(): List<FilterEntity>

    @Query("DELETE from alcohol_filters")
    suspend fun clearAlcoholFilters()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGlassTypes(
        glassEntity: List<GlassEntity>
    )

    @Query("SELECT * from glass_types")
    fun getGlassTypes(): List<GlassEntity>

    @Query("DELETE from glass_types")
    suspend fun clearGlassTypes()

}