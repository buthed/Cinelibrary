package com.tematikhonov.cinelibrary.presentation.ui.profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tematikhonov.cinelibrary.presentation.components.movieDetails.YouTubeTrailerPlayer

@Composable
fun ProfileScreen() {
    YouTubeTrailerPlayer("S0Q4gqBUs7c")
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}