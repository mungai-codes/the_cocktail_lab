package com.game.thecocktaillabs.data.remote.response

import com.game.thecocktaillabs.data.remote.dto.CategoryDto

data class CategoryResponse(
    val drinks: List<CategoryDto>
)