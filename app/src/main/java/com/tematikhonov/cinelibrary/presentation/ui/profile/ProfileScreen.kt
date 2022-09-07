package com.tematikhonov.cinelibrary.presentation.ui.profile

import android.util.AttributeSet
import androidx.annotation.NonNull
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.tematikhonov.cinelibrary.MainActivity
import com.tematikhonov.cinelibrary.R
import com.tematikhonov.cinelibrary.presentation.components.movieDetails.YouTubeTrailerPlayer
import com.tematikhonov.cinelibrary.presentation.theme.CLBTypography
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors

@Composable
fun ProfileScreen() {
    YouTubeTrailerPlayer("S0Q4gqBUs7c")
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}