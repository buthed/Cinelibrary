package com.tematikhonov.cinelibrary.presentation.components.person

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
import com.tematikhonov.cinelibrary.R
import com.tematikhonov.cinelibrary.domain.models.ApiConstants
import com.tematikhonov.cinelibrary.domain.models.ApiConstants.TMDB_IMAGE_PATH
import com.tematikhonov.cinelibrary.domain.models.entites.Person

@Composable
fun PersonDetailsBackground(person: Person) {
    AsyncImage(model = if (person.profile_path!=null && person.profile_path.isNotEmpty()
        ) TMDB_IMAGE_PATH +person.profile_path else R.drawable.image_not_available,
        contentDescription = person.name,
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