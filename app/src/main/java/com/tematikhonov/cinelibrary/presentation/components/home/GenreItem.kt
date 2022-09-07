package com.tematikhonov.cinelibrary.presentation.components.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematikhonov.cinelibrary.presentation.theme.CLBTypography

@Composable
fun GenresListCompose(genresList: List<String>) {
    LazyRow() {
        items(genresList) { item ->
            Box(
                Modifier.padding(vertical = 8.dp),
            ) {
                Text(text = item, style = CLBTypography.body2)
            }
            Spacer(Modifier.width(8.dp))
        }
    }
}

@Preview
@Composable
fun CategoriesListComposePreview() {
    val genresList = mutableListOf("All", "Comedy", "Animation", "Documentatary")
    GenresListCompose(genresList)
}

//TODO Add Second view for item, after adding model