package com.tematikhonov.cinelibrary.presentation.components.movieDetails

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematikhonov.cinelibrary.R
import com.tematikhonov.cinelibrary.presentation.core.RoundedPlayButton
import com.tematikhonov.cinelibrary.presentation.theme.CLBColors
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors

@Composable
fun ButtonsTab(modifier: Modifier = Modifier, share: () -> Unit = {}, trailerLink: String) {
    var playerVisibility by remember { mutableStateOf(false) }
    Row(modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        RoundedPlayButton("Play",Modifier.padding(vertical = 4.dp, horizontal = 24.dp),{})
        Spacer(Modifier.width(16.dp))
        Button(
            onClick = {
                Log.d("player", playerVisibility.toString())
            },
            Modifier.size(48.dp),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = LocalCLBExtraColors.current.Soft
            )) {
            Icon(
                painter = painterResource(id = R.drawable.ic_download),
                contentDescription = "",
                Modifier.size(20.dp),
                tint = LocalCLBExtraColors.current.Orange,
            )
        }
        Spacer(Modifier.width(16.dp))
        Button(
            onClick = share,
            Modifier.size(48.dp),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = LocalCLBExtraColors.current.Soft
            )) {
            Icon(painter = painterResource(id = R.drawable.ic_share),
                contentDescription = "",
                Modifier.size(20.dp),
                tint = CLBColors.primary,
            )
        }
    }

    AnimatedVisibility(visible = playerVisibility) {
        VideoPlayer()
    }

}

@Composable
fun VideoPlayer() {


//        LaunchedEffect(exoPlayer) {
//            exoPlayer.prepare()
//            exoPlayer.playWhenReady = playWhenReady
//        }

//        AndroidView(factory = {playerView}, Modifier.fillMaxSize())
//        val context = LocalContext.current
//        val url = "https://vimeo.com/658158077"
//        val player = remember {
//            ExoPlayer.Builder(context).build().apply {
//                val dataSource = DefaultDataSource.Factory(context)
//                val source = ProgressiveMediaSource.Factory(dataSource)
//                    .createMediaSource(MediaItem.fromUri(Uri.parse(url)))
//
//                addMediaSource(source)
//                prepare()
//            }
//        }


}

@Preview
@Composable
fun ButtonsTabPreview() {
    ButtonsTab(Modifier,{},"trailerLink")
}