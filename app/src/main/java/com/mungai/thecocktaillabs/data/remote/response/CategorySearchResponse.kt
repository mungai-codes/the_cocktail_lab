package com.mungai.thecocktaillabs.data.remote.response

import com.mungai.thecocktaillabs.data.remote.dto.CategorySearchDto

data class CategorySearchResponse(
    val drinks: List<CategorySearchDto>
)