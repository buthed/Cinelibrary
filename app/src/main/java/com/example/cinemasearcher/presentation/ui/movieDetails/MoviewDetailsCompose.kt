package com.example.cinemasearcher.presentation.ui.movieDetails

import android.util.Log
import androidx.compose.animation.*
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
import com.example.cinemasearcher.R
import com.example.cinemasearcher.domain.models.ApiConstants.TMDB_IMAGE_PATH
import com.example.cinemasearcher.domain.models.entites.Result
import com.example.cinemasearcher.presentation.components.home.MovieDefaultItem
import com.example.cinemasearcher.presentation.components.movieDetails.*
import com.example.cinemasearcher.presentation.theme.CLBTypography
import com.example.cinemasearcher.presentation.theme.LocalCLBExtraColors

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MovieDetailsScreen(movieId: String, navController: NavHostController) {
    var shareLinksVisibility by remember { mutableStateOf(false) }

    val viewModel = hiltViewModel<MovieDetailsViewModel>()
    viewModel.init(movieId.toInt())
    val movie =  viewModel.movie.observeAsState().value
    val credits = viewModel.credits.observeAsState().value
    val similar = viewModel.similar.observeAsState().value
    val gallery = viewModel.gallery.observeAsState().value

    if (movie!= null) {
       Surface(Modifier.fillMaxSize()) {
           MovieDetailsBackground(movie)
           Column(
               Modifier
                   .fillMaxWidth()
                   .padding(24.dp)
                   .verticalScroll(rememberScrollState())
           ) {
               Row(
                   Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.SpaceEvenly,
                   verticalAlignment = Alignment.CenterVertically,
               ) {
                   Icon(painter = painterResource(id = R.drawable.ic_arrow_back), contentDescription = "", tint = Color.White)
                   Text(text = movie.title, style = CLBTypography.h4)
                   Icon(painter = painterResource(id = R.drawable.ic_heart), contentDescription = "", tint = Color.Red)
               }
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
               ButtonsTab(Modifier.fillMaxWidth().padding(vertical = 24.dp),
                    share = {
                        shareLinksVisibility = true
                    })
               Text(text = stringResource(id = R.string.movie_story_line), style = CLBTypography.h4)
               Text(text = movie.overview,
                   Modifier.padding(top = 8.dp),
                   style = CLBTypography.h5,
                   color = LocalCLBExtraColors.current.Gray,
                   maxLines = 5,
                   overflow = TextOverflow.Clip)
               Text(text = stringResource(id = R.string.movie_cast_and_crew),
                   Modifier.padding(top = 24.dp),
                   style = CLBTypography.h4)
               if (credits!=null) CastAndCrewRow(Modifier.padding(top = 16.dp), credits.cast)
               Text(text = stringResource(id = R.string.movie_gallery),
                   Modifier.padding(top = 24.dp),
                   style = CLBTypography.h4)
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
        ShareLinkToSocialMedia {
            shareLinksVisibility = false
        }
    }
}

@Preview
@Composable
fun MovieDetailsScreenPreview(){
    val navController = rememberNavController()

    MovieDetailsScreen("555", navController)
}