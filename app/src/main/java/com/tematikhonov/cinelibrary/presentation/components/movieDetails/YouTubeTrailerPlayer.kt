package com.tematikhonov.cinelibrary.presentation.components.movieDetails

import androidx.annotation.NonNull
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.tematikhonov.cinelibrary.MainActivity
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors

@Composable
fun YouTubeTrailerPlayer(link: String, close: () -> Unit) {
    val activityLifecycle = MainActivity().lifecycle
    val context = LocalContext.current

    val youtubePlayer = remember {
        YouTubePlayerView(context).apply {
            activityLifecycle.addObserver(this)
            enableAutomaticInitialization = false
            initialize(object : AbstractYouTubePlayerListener() {
                override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                    youTubePlayer.cueVideo(link, 0f)
                }
            })
        }
    }
    Box(Modifier.background(LocalCLBExtraColors.current.Soft.copy(0.85f))
        .fillMaxSize()
        .clickable(onClick = close),
        contentAlignment = Alignment.Center
    ){
        AndroidView(
            {
                youtubePlayer
            }, modifier = Modifier
        )
    }

}