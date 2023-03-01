package com.mungai.thecocktaillabs.data.remote.response

import com.mungai.thecocktaillabs.data.remote.dto.CategoryDto

data class CategoryResponse(
    val drinks: List<CategoryDto>
)