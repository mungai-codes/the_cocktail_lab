package com.game.thecocktaillabs.presentation.cocktaildetailsscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.SmartDisplay
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.game.thecocktaillabs.R
import com.game.thecocktaillabs.presentation.ui.theme.TheCocktailLabsTheme
import com.mungaicodes.tomesanctuary.util.UiEvent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun CocktailDetailsScreen(
    navController: NavController,
    viewModel: CocktailDetailsViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()

    var isLiked by remember {
        mutableStateOf(false)
    }

    val (favouriteStatus, tint) = when (isLiked) {
        true -> Pair(Icons.Outlined.Favorite, MaterialTheme.colors.primary)
        false -> Pair(Icons.Outlined.FavoriteBorder, Color.Black)
    }

    val state = viewModel.uiState.collectAsState().value

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState
    ) { innerPadding ->
        if (!state.drink.isNullOrEmpty()) {
            state.drink.forEach { drink ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = innerPadding.calculateTopPadding()),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1.5f),
                        elevation = 8.dp,

                        ) {
                        Box(modifier = Modifier.fillMaxSize()) {
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(data = drink.strDrinkThumb)
                                    .crossfade(true)
                                    .placeholder(R.drawable.loading_img)
                                    .error(R.drawable.ic_broken_image)
                                    .build(),
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier.fillMaxSize(),
                                contentDescription = drink.strDrink
                            )
                            IconButton(
                                onClick = { isLiked = !isLiked },
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                                    .padding(top = 8.dp, end = 8.dp)
                            ) {
                                Icon(
                                    imageVector = favouriteStatus,
                                    contentDescription = "favourite",
                                    tint = tint,
                                    modifier = Modifier.size(40.dp)
                                )
                            }
                            Row(
                                modifier = Modifier
                                    .align(Alignment.BottomStart)
                                    .fillMaxWidth()
                                    .background(
                                        brush = Brush.verticalGradient(
                                            listOf(
                                                Color.Transparent,
                                                Color(0xFFFF9800).copy(alpha = 0.3f),
                                                Color(0xFFC95252).copy(alpha = 0.4f),
                                                Color(0xFF63A4D8).copy(alpha = 0.5f),
                                            )
                                        )
                                    ),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                drink.strDrink?.let {
                                    Text(
                                        text = it,
                                        fontFamily = FontFamily.SansSerif,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color(0xFFF4F4F4),
                                        fontSize = 25.sp,
                                        textAlign = TextAlign.Start,
                                        maxLines = 2,
                                        overflow = TextOverflow.Ellipsis,
                                        modifier = Modifier
                                            .padding(start = 8.dp)
                                            .weight(1f)
                                    )
                                }
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Outlined.SmartDisplay,
                                        contentDescription = "youtube",
                                        tint = Color(0xFFFE0000),
                                        modifier = Modifier
                                            .size(40.dp)
                                            .padding(end = 8.dp)
                                            .weight(1f)
                                    )
                                }
                            }
                        }
                    }
                    IngredientDetails(
                        modifier = Modifier.weight(1f),
                        heading = "Ingredients",
                        ingredients = drink.ingredients!!
                    ) { data ->
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            if (!data.ingredient.isNullOrBlank() && data.imageUrl != null) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(text = data.ingredient.length.toString())
                                    Text(text = data.measure!!)
                                    AsyncImage(
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data(data.imageUrl)
                                            .crossfade(true)
                                            .placeholder(R.drawable.loading_img)
                                            .error(R.drawable.ic_broken_image)
                                            .build(),
                                        contentScale = ContentScale.Crop,
                                        contentDescription = data.ingredient
                                    )
                                }
                            }
                        }
                    }

                    Instructions(modifier = Modifier.weight(1f), heading = "Instructions") {
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            drink.strInstructions?.let { Text(text = it) }
                        }
                    }

                    if (state.loading) {
                        CircularProgressIndicator()
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CocktailDetailsPreview() {
    TheCocktailLabsTheme {
        CocktailDetailsScreen(navController = rememberNavController())
    }
}