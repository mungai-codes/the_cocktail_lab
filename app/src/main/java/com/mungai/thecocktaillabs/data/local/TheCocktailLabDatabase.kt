package com.mungai.thecocktaillabs.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mungai.thecocktaillabs.data.local.entity.CategoryEntity
import com.mungai.thecocktaillabs.data.local.entity.FavouriteCocktailEntity
import com.mungai.thecocktaillabs.data.local.entity.FilterEntity
import com.mungai.thecocktaillabs.data.local.entity.GlassEntity

@Database(
    entities = [
        FavouriteCocktailEntity::class,
        CategoryEntity::class,
        FilterEntity::class,
        GlassEntity::class
    ],
    version = 3,
    exportSchema = false
)
abstract class TheCocktailLabDatabase : RoomDatabase() {
    abstract val dao: TheCockTailLabDao
}