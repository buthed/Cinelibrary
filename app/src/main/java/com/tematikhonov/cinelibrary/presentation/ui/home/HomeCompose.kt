package com.tematikhonov.cinelibrary.presentation.ui.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tematikhonov.cinelibrary.R
import com.tematikhonov.cinelibrary.presentation.components.ContentSeeAll
import com.tematikhonov.cinelibrary.presentation.components.ContentTitle
import com.tematikhonov.cinelibrary.presentation.components.home.CategoriesItem
import com.tematikhonov.cinelibrary.presentation.components.home.MovieDefaultItem
import com.tematikhonov.cinelibrary.presentation.components.home.UpcomingSelector
import com.tematikhonov.cinelibrary.presentation.components.home.UpcomingViewPager
import com.tematikhonov.cinelibrary.presentation.core.SearchField
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel = hiltViewModel<HomeViewModel>()
    val genres = viewModel.genres.observeAsState().value
    val popularMovies = viewModel.popularMovies.observeAsState().value
    val upcomingMovies = viewModel.upcomingMovies.observeAsState().value

    Log.d("checkDataM", "popularMovies: ${popularMovies?.results?.get(0)}" )
    Log.d("checkDataM", "upcomingMovies: ${upcomingMovies?.results?.get(0)}" )

    Box(
        Modifier
            .fillMaxSize()
            .background(LocalCLBExtraColors.current.Dark)
    ) {
        Column(Modifier.padding(top = 24.dp)) {
            Box(Modifier.padding(horizontal = 24.dp)){
                SearchField(input = "", onValueChange = {}, label = "Search a title", value = "")
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                if (upcomingMovies!=null) {
                    UpcomingViewPager(upcomingMovies.results,
                        navController
                    )
                }
                Spacer(Modifier.height(12.dp))
                UpcomingSelector()
            }
            Column() {
                Row(Modifier.fillMaxWidth(),
                    Arrangement.SpaceBetween,
                    Alignment.CenterVertically
                ) {
                    ContentTitle(stringResource(id = R.string.home_categories))
                    ContentSeeAll()
                }
                LazyRow(
                    Modifier
                        .padding(top = 15.dp)
                        .absoluteOffset(x = 24.dp)
                ) {
                    if (genres!=null) {
                        items(genres.genres) { item ->
                            CategoriesItem(item)
                            Spacer(Modifier.width(8.dp))
                        }
                    }
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 21.dp), Arrangement.SpaceBetween, Alignment.CenterVertically, ) {
                    ContentTitle(stringResource(id = R.string.home_most_popular))
                    ContentSeeAll()
                }
                LazyRow(Modifier.padding(top = 16.dp, start = 24.dp)){
                    if (popularMovies != null) {
                        items(popularMovies.results) { item->
                            MovieDefaultItem(item,
                                navController
                            )
                            Spacer(Modifier.width(12.dp))
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
  //  HomeScreen(viewModel)
}

//TODO Add scroll HomeScreen
//TODO Add All button for categories
//TODO Add ViewPager on Upcoming Movies
//TODO Optimize titles

