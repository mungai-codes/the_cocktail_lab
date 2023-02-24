package com.game.thecocktaillabs.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.game.thecocktaillabs.data.local.entity.CategoryEntity

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

}