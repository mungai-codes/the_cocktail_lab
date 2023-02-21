package com.game.thecocktaillabs.presentation.homescreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExpandLess
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun FabButton(
    homeButtonClicked: () -> Unit,
    favouritesButtonClicked: () -> Unit,
    searchButtonClicked: () -> Unit
) {

    var isCollapsed by remember {
        mutableStateOf(false)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        AnimatedVisibility(
            visible = isCollapsed,
            enter = slideIn(tween(1000, easing = LinearOutSlowInEasing)) {
                IntOffset(0, 500)
            },
            exit = slideOut(tween(1000, easing = FastOutSlowInEasing)) {
                IntOffset(0, 500)
            },
        ) {
            FabMenu(
                homeButtonClicked = { homeButtonClicked() },
                favouritesButtonClicked = { favouritesButtonClicked() },
                searchButtonClicked = { searchButtonClicked() }
            )
        }
        FloatingActionButton(
            onClick = { isCollapsed = !isCollapsed },
            shape = CircleShape,
            elevation = FloatingActionButtonDefaults.elevation(8.dp),
            backgroundColor = MaterialTheme.colors.primary
        ) {
            if (isCollapsed) {
                Icon(
                    imageVector = Icons.Outlined.ExpandLess,
                    contentDescription = "close fab"
                )
            } else

                Icon(
                    imageVector = Icons.Outlined.ExpandMore,
                    contentDescription = "open fab",
                )
        }
    }


}