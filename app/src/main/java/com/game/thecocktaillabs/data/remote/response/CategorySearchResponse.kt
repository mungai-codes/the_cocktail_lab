package com.game.thecocktaillabs.data.remote.response

import com.game.thecocktaillabs.data.remote.dto.CategorySearchDto

data class CategorySearchResponse(
    val drinks: List<CategorySearchDto>
)