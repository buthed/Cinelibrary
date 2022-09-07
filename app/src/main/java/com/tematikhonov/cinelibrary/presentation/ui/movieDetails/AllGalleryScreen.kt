package com.tematikhonov.cinelibrary.presentation.ui.movieDetails

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.tematikhonov.cinelibrary.R
import com.tematikhonov.cinelibrary.domain.models.ApiConstants.TMDB_IMAGE_PATH
import com.tematikhonov.cinelibrary.presentation.components.movieDetails.StaggeredVerticalGrid
import com.tematikhonov.cinelibrary.presentation.theme.CLBTypography
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors
import com.tematikhonov.cinelibrary.presentation.ui.ImageFullScreen

@OptIn(ExperimentalAnimationApi::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun AllGalleryScreen(movieId: String, navController: NavHostController) {
    var fullScreenVisibility by remember { mutableStateOf(false) }
    var linkForShare by remember { mutableStateOf("")}
    val viewModel = hiltViewModel<MovieDetailsViewModel>()
    viewModel.init(movieId.toInt())
    val movie =  viewModel.movie.observeAsState().value
    val gallery = viewModel.gallery.observeAsState().value

    if (movie!=null) {
        Column(
            Modifier
                .fillMaxSize()
                .background(LocalCLBExtraColors.current.Dark)
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "",
                    Modifier.clickable(onClick = { navController.popBackStack() }),
                    tint = Color.White,
                )
                Column() {
                    Text(text = movie.title, style = CLBTypography.h4)
                    Text(
                        text = stringResource(id = R.string.movie_images),
                        Modifier.align(CenterHorizontally),
                        style = CLBTypography.subtitle1,
                        textAlign = TextAlign.Center
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.ic_share),
                    contentDescription = "",
                    tint = Color.Transparent,
                )
            }
            if (gallery!=null) {
                LazyColumn {
                    item {
                        StaggeredVerticalGrid(
                            maxColumnWidth = 150.dp,
                            modifier = Modifier.padding(4.dp)
                        ) {
                            val data = gallery.backdrops.plus(gallery.posters).shuffled()
                            data.forEach { image ->
                                AsyncImage(
                                    model = TMDB_IMAGE_PATH + image.file_path,
                                    contentDescription = "",
                                    Modifier
                                        .padding(10.dp)
                                        .clickable(onClick = {
                                            fullScreenVisibility = true
                                            linkForShare = image.file_path
                                        }))
                            }
                        }
                    }
                }
            }
        }
        AnimatedVisibility(visible = fullScreenVisibility,
            enter = fadeIn() + scaleIn(),
            exit = fadeOut() + scaleOut()
        ) {
            ImageFullScreen(imagePath = linkForShare,
                closeAction = { fullScreenVisibility = false })
        }
    }
}

@Preview
@Composable
fun AllGalleryScreenPreview() {
    val navController = rememberNavController()
    AllGalleryScreen("555", navController)
}