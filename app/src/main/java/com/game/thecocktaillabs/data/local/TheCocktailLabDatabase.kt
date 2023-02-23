package com.game.thecocktaillabs.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.game.thecocktaillabs.data.local.entity.FavouriteCocktailEntity

@Database(entities = [FavouriteCocktailEntity::class], version = 1, exportSchema = false)
abstract class TheCocktailLabDatabase : RoomDatabase() {
    abstract val dao: TheCockTailLabDao
}