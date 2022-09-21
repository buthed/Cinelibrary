package com.tematikhonov.cinelibrary.presentation.ui.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematikhonov.cinelibrary.domain.models.enumeration.SearchCategory.ACTORS
import com.tematikhonov.cinelibrary.domain.models.enumeration.SearchCategory.MOVIES
import com.tematikhonov.cinelibrary.presentation.components.search.SearchCategory
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors

@Composable
fun FavoritesScreen() {
    var chosenCategory by remember { mutableStateOf(MOVIES) }
    Box(
        Modifier
            .fillMaxSize()
            .background(LocalCLBExtraColors.current.Dark)
    ) {
        Column() {
            Row(
                Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                SearchCategory(MOVIES, chosenCategory) { chosenCategory = MOVIES }
                SearchCategory(ACTORS, chosenCategory) { chosenCategory = ACTORS }
            }
            when (chosenCategory) {
                MOVIES -> {
//                    LazyColumn {
//                        items(searchResultMovie.results) { item ->
//                            MovieSearchItem(navController, item)
//                            Spacer(Modifier.height(16.dp))
//                        }
//                    }
                }
                ACTORS -> {
//                    LazyColumn {
//                        items(searchResultPerson.results) { item ->
//                            PersonSearchItem(navController, item)
//                            Spacer(Modifier.height(16.dp))
//                        }
//                    }
                }
                else -> {}
            }
        }
    }
}

@Preview
@Composable
fun FavoritesScreenPreview() {
    FavoritesScreen()
}