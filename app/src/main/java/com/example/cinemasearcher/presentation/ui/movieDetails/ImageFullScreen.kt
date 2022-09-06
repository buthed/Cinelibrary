package com.example.cinemasearcher.presentation.ui

import android.util.Log
import androidx.compose.animation.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.cinemasearcher.R
import com.example.cinemasearcher.domain.models.ApiConstants.TMDB_IMAGE_PATH
import com.example.cinemasearcher.presentation.components.movieDetails.ShareLinkToSocialMedia

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ImageFullScreen(imagePath: String,closeAction: () -> Unit,) {
    var shareImageLinkVisibility by remember { mutableStateOf(false) }
    Column() {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Top,
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_share),
                contentDescription = "",
                Modifier.padding(end = 24.dp).clickable(onClick = {
                    shareImageLinkVisibility = true
                    Log.d("share", "Share $imagePath")
                }),
                tint = Color.White)
        }
        Box(        Modifier
            .fillMaxSize()
            .blur(40.dp)
            .padding(horizontal = 24.dp)
            .clickable(onClick = closeAction),
            contentAlignment = Alignment.Center){
            AsyncImage(model = TMDB_IMAGE_PATH + imagePath, contentDescription = "", Modifier.fillMaxSize())
        }
    }
    AnimatedVisibility(
        visible = shareImageLinkVisibility,
        enter = fadeIn() + scaleIn(),
        exit = fadeOut() + scaleOut()
    ) {
        ShareLinkToSocialMedia(closeAction = { shareImageLinkVisibility = false },
            link = TMDB_IMAGE_PATH+imagePath)
    }
}

@Preview
@Composable
fun ImageFullScreenPreview() {
    ImageFullScreen("123", {})
}