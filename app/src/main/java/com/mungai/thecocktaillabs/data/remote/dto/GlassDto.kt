package com.mungai.thecocktaillabs.data.remote.dto

import com.mungai.thecocktaillabs.data.local.entity.GlassEntity
import com.squareup.moshi.Json

data class GlassDto(
    @field:Json(name = "strGlass")
    val strGlass: String
) {

    fun toGlassEntity(): GlassEntity {
        return GlassEntity(
            glassType = strGlass
        )
    }
}