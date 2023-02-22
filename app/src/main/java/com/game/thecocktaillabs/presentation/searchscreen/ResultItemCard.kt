package com.game.thecocktaillabs.presentation.searchscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.game.thecocktaillabs.R

@Composable
fun ResultItemCard(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .height(140.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.favourite_cocktail),
                contentDescription = "test",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
        }
    }
}