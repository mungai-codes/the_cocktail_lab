package com.mungai.thecocktaillabs.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mungai.thecocktaillabs.domain.model.Category

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
