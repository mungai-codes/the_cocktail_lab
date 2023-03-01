package com.game.thecocktaillabs.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.game.thecocktaillabs.data.local.entity.CategoryEntity
import com.game.thecocktaillabs.data.local.entity.FavouriteCocktailEntity
import com.game.thecocktaillabs.data.local.entity.FilterEntity
import com.game.thecocktaillabs.data.local.entity.GlassEntity

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