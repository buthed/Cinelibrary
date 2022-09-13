package com.tematikhonov.cinelibrary.presentation.ui.movieDetails

import android.util.Log
import androidx.compose.animation.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.tematikhonov.cinelibrary.R
import com.tematikhonov.cinelibrary.domain.models.ApiConstants.TMDB_IMAGE_PATH
import com.tematikhonov.cinelibrary.presentation.components.home.MovieDefaultItem
import com.tematikhonov.cinelibrary.presentation.components.movieDetails.*
import com.tematikhonov.cinelibrary.presentation.theme.CLBTypography
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors
import com.tematikhonov.cinelibrary.presentation.theme.clbLightExtraColors

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MovieDetailsScreen(movieId: String, navController: NavHostController) {
    var shareLinksVisibility by remember { mutableStateOf(false) }
    var playerVisibility by remember { mutableStateOf(false) }
    var trailerLink by remember { mutableStateOf("") }

    val viewModel = hiltViewModel<MovieDetailsViewModel>()
    viewModel.init(movieId.toInt())
    val movie =  viewModel.movie.observeAsState().value
    val credits = viewModel.credits.observeAsState().value
    val similar = viewModel.similar.observeAsState().value
    val gallery = viewModel.gallery.observeAsState().value
    val videos = viewModel.videos.observeAsState().value

    if (videos!=null) {
        for(i in 0..videos.results.size) {
            if (videos.results[i].type == "Trailer" && videos.results[i].site == "YouTube") {
                trailerLink = videos.results[i].key
                break
            }
        }
    }
    Surface(Modifier.fillMaxSize()) {
        if (movie!= null) {
            MovieDetailsBackground(movie)
            Column(Modifier.padding(horizontal = 24.dp)) {
                Box(contentAlignment = Alignment.TopCenter){
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top,
                    ) {
                        Icon(painter = painterResource(id = R.drawable.ic_arrow_left),
                            contentDescription = "",
                            Modifier.clickable {navController.popBackStack()},
                            tint = Color.White,)
                        Text(text = movie.title, style = CLBTypography.h4)
                        Icon(painter = painterResource(id = R.drawable.ic_heart), contentDescription = "", tint = Color.Red)
                    }
                }
                Column(
                    Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {
                    Spacer(Modifier.height(24.dp))
                    AsyncImage(
                        model = TMDB_IMAGE_PATH+movie.poster_path,
                        contentDescription = movie.title,
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 70.dp),
                        contentScale = ContentScale.FillWidth,
                        alignment = Alignment.TopCenter)
                    InfoTab(movie)
                    ButtonsTab(
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp),
                        share = { shareLinksVisibility = true },
                        playTrailer = {
                            playerVisibility = true
                            Log.d("player", playerVisibility.toString())
                        },
                        trailerLink = trailerLink
                    )
                    Text(text = stringResource(id = R.string.movie_story_line), style = CLBTypography.h4)
                    Text(text = movie.overview,
                        Modifier.padding(top = 8.dp),
                        style = CLBTypography.h5,
                        color = LocalCLBExtraColors.current.Gray,
                        maxLines = 5,
                        overflow = TextOverflow.Clip)
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(text = stringResource(id = R.string.movie_cast_and_crew),
                            style = CLBTypography.h4)
                        Text(
                            text = stringResource(id = R.string.home_see_all),
                            style = CLBTypography.h4,
                            color = clbLightExtraColors.BlueAccent)
                    }
                    if (credits!=null) CastAndCrewRow(Modifier.padding(top = 16.dp), credits.cast)
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(text = stringResource(id = R.string.movie_gallery),
                            style = CLBTypography.h4)
                        Text(
                            text = stringResource(id = R.string.home_see_all),
                            Modifier.clickable{
                                navController.navigate("MovieDetailsGallery/${movie.id}")
                                              },
                            style = CLBTypography.h4,
                            color = clbLightExtraColors.BlueAccent)
                    }
                    if (gallery!=null) {
                        LazyRow(Modifier.padding(top = 16.dp)){
                            items(gallery.backdrops) { item ->
                                AsyncImage(
                                    modifier = Modifier.height(90.dp),
                                    model = TMDB_IMAGE_PATH+item.file_path,
                                    contentDescription = "",
                                    contentScale = ContentScale.FillWidth)
                                Spacer(Modifier.width(10.dp))
                            }
                        }
                    }
                    if (similar!=null) {
                        Text(text = stringResource(id = R.string.movie_similar_movies),
                            Modifier.padding(top = 24.dp),
                            style = CLBTypography.h4)
                        LazyRow(Modifier.padding(top = 16.dp)){
                            items(similar.results) { item->
                                MovieDefaultItem(item, navController)
                                Spacer(Modifier.width(12.dp))
                            }
                        }
                    }
                }
            }
        }
        AnimatedVisibility(visible = shareLinksVisibility,
            enter = fadeIn() + scaleIn(),
            exit = fadeOut() + scaleOut()
        ) {
            movie?.let {
                ShareLinkToSocialMedia(closeAction = { shareLinksVisibility = false },
                    it.homepage
                )
            }
        }
        AnimatedVisibility(visible = playerVisibility) {
            YouTubeTrailerPlayer(trailerLink, close = {
                playerVisibility = false
                Log.d("player", "player $playerVisibility")
            })
        }
    }
}

@Preview
@Composable
fun MovieDetailsScreenPreview(){
    val navController = rememberNavController()

    MovieDetailsScreen("555", navController)
}