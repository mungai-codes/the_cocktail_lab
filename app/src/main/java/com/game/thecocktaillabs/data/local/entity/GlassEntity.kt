package com.game.thecocktaillabs.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.game.thecocktaillabs.domain.model.Glass

@Entity(tableName = "glass_types")
data class GlassEntity(
    @PrimaryKey
    val id: Int? = null,
    val glassType: String
) {
    fun toGlass(): Glass {
        return Glass(
            strGlass = glassType
        )
    }
}
