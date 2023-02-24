package com.game.thecocktaillabs.data.remote.dto

import com.game.thecocktaillabs.data.local.entity.FilterEntity
import com.game.thecocktaillabs.domain.model.Filter
import com.squareup.moshi.Json

data class FilterDto(
    @field:Json(name = "strAlcoholic")
    val strAlcoholic: String
) {
    fun toFilterEntity() : FilterEntity {
        return FilterEntity(
            filter = strAlcoholic
        )
    }
}