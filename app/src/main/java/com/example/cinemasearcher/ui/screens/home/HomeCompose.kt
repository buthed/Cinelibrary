package com.example.cinemasearcher.ui.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemasearcher.R
import com.example.cinemasearcher.ui.components.home.CategoriesItem
import com.example.cinemasearcher.ui.components.home.MovieDefaultItem
import com.example.cinemasearcher.ui.components.home.NewsItem
import com.example.cinemasearcher.ui.components.home.NewsSelector
import com.example.cinemasearcher.ui.core.SearchField
import com.example.cinemasearcher.ui.theme.CLBTypography
import com.example.cinemasearcher.ui.theme.LocalCLBExtraColors
import com.example.cinemasearcher.ui.theme.clbLightExtraColors
import com.example.cinemasearcher.viewmodel.MainViewModel

@Composable
fun HomeScreen(viewModel: MainViewModel) {
//    val popularMovies = viewModel.popularMovies.observeAsState(listOf()).value
//    popularMovies.forEach{ Log.d("checkData","ID: ${it.id} name: ${it.original_title}")}
    val movie = viewModel.movie.observeAsState().value
    val popMovies = viewModel.popularMovies.observeAsState().value
    Log.d("checkDataM", "ID: ${movie?.id} title: ${movie?.original_title}" )
    Log.d("checkDataM", "LIST: ${popMovies.toString()} title: ${movie?.original_title}" )
    Box(
        Modifier
            .fillMaxSize()
            .background(LocalCLBExtraColors.current.Dark)
    ) {
        Column(Modifier.padding(top = 24.dp)) {
            Box(Modifier.padding(horizontal = 24.dp)){
                SearchField(input = "", onValueChange = {}, label = "Search a title")
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                NewsItem()
                Spacer(Modifier.height(12.dp))
                NewsSelector()
            }
            Column(Modifier.padding(horizontal = 24.dp)) {
                Text(
                    text = stringResource(id = R.string.home_categories),
                    style = CLBTypography.h4,
                    color = Color.White
                    )
                LazyRow(Modifier.padding(top = 15.dp)) {
                    items(5){item->
                        CategoriesItem()
                        Spacer(Modifier.width(8.dp))
                    }
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 21.dp), Arrangement.SpaceBetween, Alignment.CenterVertically, ) {
                    Text(
                        text = stringResource(id = R.string.home_most_popular),
                        style = CLBTypography.h4,
                        color = Color.White)
                    Text(
                        text = stringResource(id = R.string.home_see_all),
                        style = CLBTypography.h4,
                        color = clbLightExtraColors.BlueAccent)
                }
                LazyRow(Modifier.padding(top = 16.dp)){
                    items(5){item->
                        MovieDefaultItem()
                        Spacer(Modifier.width(12.dp))
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