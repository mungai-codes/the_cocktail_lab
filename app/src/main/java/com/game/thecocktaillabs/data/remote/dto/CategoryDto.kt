package com.game.thecocktaillabs.data.remote.dto

import com.game.thecocktaillabs.data.local.entity.CategoryEntity
import com.squareup.moshi.Json

data class CategoryDto(
    @field:Json(name = "strCategory")
    val strCategory: String
) {
    fun toCategoryEntity(): CategoryEntity {
        return CategoryEntity(
            strCategory = strCategory
        )
    }
}