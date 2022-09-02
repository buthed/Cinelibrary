package com.example.cinemasearcher.presentation.components.search

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.cinemasearcher.R
import com.example.cinemasearcher.domain.models.ApiConstants
import com.example.cinemasearcher.domain.models.entites.*
import com.example.cinemasearcher.presentation.components.movieDetails.InfoTabIcon
import com.example.cinemasearcher.presentation.components.movieDetails.InfoTabSeparator
import com.example.cinemasearcher.presentation.components.movieDetails.InfoTabText
import com.example.cinemasearcher.presentation.theme.CLBTypography
import com.example.cinemasearcher.presentation.theme.LocalCLBExtraColors

@Composable
fun SearchItem(navController: NavHostController, movie: Result) {
    val movie1 = Movie(
        adult=false,
        backdrop_path="/jsoz1HlxczSuTx0mDl2h0lxy36l.jpg",
        belongs_to_collection = "1",
        budget = 111,
        genres = listOf(Genre(1,"Action"), Genre(2,"Drama")),
        homepage = "1",
        id=616037,
        imdb_id = "550",
        original_language="en",
        original_title="Thor: Love and Thunder, overview=After his retirement is interrupted by Gorr the God Butcher, a galactic killer who seeks the extinction of the gods, Thor Odinson enlists the help of King Valkyrie, Korg, and ex-girlfriend Jane Foster, who now inexplicably wields Mjolnir as the Relatively Mighty Girl Thor. Together they embark upon a harrowing cosmic adventure to uncover the mystery of the God Butcher’s vengeance and stop him before it’s too late.",
        overview = "",
        popularity=7172.102,
        poster_path="/pIkRyD18kl4FhoCNQuWxWu5cBLM.jpg",
        production_companies = listOf<ProductionCompany>(),
        production_countries = listOf<ProductionCountry>(),
        release_date= "2022-07-06",
        revenue = 1,
        runtime = 130,
        spoken_languages = listOf(),
        status = "1",
        tagline = "",
        title="Thor: Love and Thunder",
        video=false,
        vote_average=6.8,
        vote_count=2034)
    Row(Modifier.clickable {
        Log.d("checkDataM", "ID: ${movie.id} title: ${movie.original_title}")
        navController.navigate("MovieDetails/${movie.id}")
    }) {
        Box(
            Modifier
                .width(150.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
            Column() {
                AsyncImage(model = ApiConstants.TMDB_IMAGE_PATH +movie.poster_path,
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
        Column() {
            Text(text = movie.title,
                style = CLBTypography.h4,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis)
            Spacer(Modifier.height(12.dp))
            Row() {
                InfoTabIcon(painterResource(id = R.drawable.ic_calendar), "")
                InfoTabText(text = movie.release_date.dropLast(6))
            }
            Spacer(Modifier.height(12.dp))
//            Row() {
//                InfoTabIcon(painterResource(id = R.drawable.ic_clock), "")
//                InfoTabText(text = movie.runtime.toString() + " Minutes")
//            }
//            Spacer(Modifier.height(12.dp))
//            Row() {
//                InfoTabIcon(painterResource(id = R.drawable.ic_film), "")
//                InfoTabText(text = movie.genres[0].name)
//                InfoTabSeparator()
//                InfoTabText(text = "Movie")
//            }
        }
    }
}

//@Preview
//@Composable
//fun SearchItemPreview() {
//    val navController = rememberNavController()
//    SearchItem(navController, item)
//}