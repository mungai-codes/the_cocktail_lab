package com.mungai.thecocktaillabs.presentation.homescreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocalBar
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun FabMenu(
    modifier: Modifier = Modifier,
    homeButtonClicked: () -> Unit,
    favouritesButtonClicked: () -> Unit,
    searchButtonClicked: () -> Unit
) {
    Surface(
        modifier = modifier
            .padding(end = 8.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(color = MaterialTheme.colors.primary, width = 1.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            FabMenuItem(
                icon = Icons.Outlined.Home,
                description = "Home",
                onClick = { homeButtonClicked() }
            )
            FabMenuItem(
                icon = Icons.Outlined.LocalBar,
                description = "Favourites",
                onClick = { favouritesButtonClicked() }
            )
            FabMenuItem(
                icon = Icons.Outlined.Search,
                description = "Search",
                onClick = { searchButtonClicked() }
            )
        }
    }
}

@Composable
fun FabMenuItem(
    icon: ImageVector,
    description: String,
    onClick: () -> Unit,
) {
    IconButton(onClick = { onClick() }) {
        Icon(
            imageVector = icon,
            contentDescription = description,
            tint = MaterialTheme.colors.primary
        )
    }

}