package com.example.cinemasearcher.presentation.components.movieDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.example.cinemasearcher.domain.models.ApiConstants
import com.example.cinemasearcher.domain.models.entites.Movie

@Composable
fun MovieDetailsBackground(movie: Movie) {
    AsyncImage(
        model = ApiConstants.TMDB_IMAGE_PATH +movie.poster_path,
        contentDescription = movie.title,
        Modifier.fillMaxSize(),
        contentScale = ContentScale.FillWidth,
        alignment = Alignment.TopCenter
    )
    Box(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    0.0f to Color(0xFF1F1D2B).copy(alpha = 0.8f),
                    100.0f to Color(0xFF1F1D2B),
                    startY = 0.0f,
                    endY = 1400.0f
                )
            ))
}