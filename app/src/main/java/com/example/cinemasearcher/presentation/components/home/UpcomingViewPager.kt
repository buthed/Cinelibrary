package com.example.cinemasearcher.presentation.components.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.cinemasearcher.domain.models.ApiConstants
import com.example.cinemasearcher.domain.models.entites.Result
import com.example.cinemasearcher.presentation.NavItem
import com.example.cinemasearcher.presentation.theme.CLBTypography
import com.example.cinemasearcher.presentation.ui.home.HomeViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue


@OptIn(ExperimentalPagerApi::class)
@Composable
fun UpcomingViewPager(data: List<Result>, navController: NavController) {

    val pageCount = data.size
    val startIndex = data.size / 2
    val pagerState = rememberPagerState(initialPage = startIndex)

    HorizontalPager(
        count = pageCount,
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 40.dp),
    ) { page ->

        UpcomingItem(
            Modifier
                .fillMaxWidth().height(160.dp)
                .clip(RoundedCornerShape(16.dp))
                .graphicsLayer {
                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                    lerp(
                        start = 0.85f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }

                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                }
                .clickable {
                    Log.d("checkDataM", "ID: ${data[page].id} title: ${data[page].original_title}")
                    navController.navigate("MovieDetails/${data[page].id}")
                },
            data[page],
        )
    }
}

@Composable
fun UpcomingItem(modifier: Modifier, movie: Result) {
    Card(modifier = modifier) {
        AsyncImage(
            model = ApiConstants.TMDB_IMAGE_PATH+movie.backdrop_path,
            contentDescription = movie.title,
            Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
        )
        Box(
            Modifier
                .fillMaxWidth()
                .heightIn(min = 150.dp)
                .padding(16.dp),
            contentAlignment = Alignment.BottomStart){
            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.Start,) {
                Text(text = movie.title, style = CLBTypography.h4)
                Spacer(Modifier.height(4.dp))
                Text(text = movie.release_date, style = CLBTypography.body2)
            }
        }
    }
}

@Preview
@Composable
fun UpcomingItemPreview() {
    val item = Result(
        adult=false,
        backdrop_path="/jsoz1HlxczSuTx0mDl2h0lxy36l.jpg",
        genre_ids= listOf(28, 12, 14),
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
    UpcomingItem(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp)), item)
}


//TODO Add View pager