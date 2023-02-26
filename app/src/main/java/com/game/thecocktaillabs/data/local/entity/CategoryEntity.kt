package com.game.thecocktaillabs.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.game.thecocktaillabs.domain.model.Category

@Entity(tableName = "cocktail_categories")
data class CategoryEntity(
    @PrimaryKey
    val categoryId: Int? = null,
    val strCategory: String
) {
    fun toCategory(): Category {
        return Category(
            strCategory = strCategory
        )
    }
}
