package com.tematikhonov.cinelibrary.presentation.components.search

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.tematikhonov.cinelibrary.R
import com.tematikhonov.cinelibrary.domain.models.ApiConstants.TMDB_IMAGE_PATH
import com.tematikhonov.cinelibrary.domain.models.entites.Movie
import com.tematikhonov.cinelibrary.presentation.components.movieDetails.InfoTabIcon
import com.tematikhonov.cinelibrary.presentation.components.movieDetails.InfoTabSeparator
import com.tematikhonov.cinelibrary.presentation.components.movieDetails.InfoTabText
import com.tematikhonov.cinelibrary.presentation.theme.CLBTypography
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors
import com.tematikhonov.cinelibrary.presentation.ui.home.HomeViewModel

@Composable
fun MovieSearchItem(navController: NavHostController, movie: Movie) {
    val viewModel = hiltViewModel<HomeViewModel>()
    val genres = viewModel.genres.observeAsState().value
    var genre by remember { mutableStateOf("")}
    if (genres!=null && movie.genre_ids.isNotEmpty()) {
        genres.genres.forEach{
            if (it.id == movie.genre_ids.first()) genre = it.name
        }

    }
    Row(Modifier.fillMaxWidth().clickable {
        Log.d("checkDataM", "ID: ${movie.id} title: ${movie.original_title}")
        navController.navigate("MovieDetails/${movie.id}")
    }) {
        Box(
            Modifier
                .width(150.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
            Column() {
                AsyncImage(model = if (movie.poster_path!=null && movie.poster_path.isNotEmpty()
                    ) TMDB_IMAGE_PATH +movie.poster_path else R.drawable.image_not_available,
                    contentDescription = movie.title)
            }
            Box(
                Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
            ) {
                Card(
                    Modifier.padding(top = 8.dp),
                    backgroundColor = LocalCLBExtraColors.current.Soft,
                    contentColor = LocalCLBExtraColors.current.Soft,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(
                        Modifier
                            .width(55.dp)
                            .height(24.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_star),
                            contentDescription = "",
                            Modifier.size(16.dp),
                            tint = LocalCLBExtraColors.current.Orange,
                        )
                        Spacer(Modifier.width(5.dp))
                        Text(
                            text = movie.vote_average.toString(),
                            textAlign = TextAlign.End,
                            style = CLBTypography.body2,
                            color = LocalCLBExtraColors.current.Orange,
                        )
                    }
                }
            }
        }
        Spacer(Modifier.width(16.dp))
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(text = movie.title,
                style = CLBTypography.h4,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis)
            Row() {
                InfoTabIcon(painterResource(id = R.drawable.ic_calendar), "")
                InfoTabText(text = if (movie.release_date!=null && movie.release_date.isNotEmpty()) movie.release_date else stringResource(id = R.string.no_data)) //TODO dropLast(6) error
            }
//            Row() {
//                InfoTabIcon(painterResource(id = R.drawable.ic_clock), "")
//                InfoTabText(text = movie.runtime.toString() + " Minutes")
//            }
            if (genre.isNotEmpty()) {
                Row() {
                    InfoTabIcon(painterResource(id = R.drawable.ic_film), "")
                    InfoTabText(text = genre) //TODO add data with genres
                    InfoTabSeparator()
                    InfoTabText(text = "Movie")
                }
            }

        }
    }
}

@Preview
@Composable
fun MovieSearchItemPreview() {
    val navController = rememberNavController()
    val movie = Movie(
        adult=false,
        backdrop_path="/jsoz1HlxczSuTx0mDl2h0lxy36l.jpg",
        genre_ids = listOf(1,2,3),
        id=616037,
        original_language="en",
        original_title="Thor: Love and Thunder, overview=After his retirement is interrupted by Gorr the God Butcher, a galactic killer who seeks the extinction of the gods, Thor Odinson enlists the help of King Valkyrie, Korg, and ex-girlfriend Jane Foster, who now inexplicably wields Mjolnir as the Relatively Mighty Girl Thor. Together they embark upon a harrowing cosmic adventure to uncover the mystery of the God Butcher’s vengeance and stop him before it’s too late.",
        overview = "",
        popularity=7172.102,
        poster_path="/pIkRyD18kl4FhoCNQuWxWu5cBLM.jpg",
        release_date= "2022-07-06",
        title="Thor: Love and Thunder",
        video=false,
        vote_average=6.8,
        vote_count=2034)

    MovieSearchItem(navController, movie)
}