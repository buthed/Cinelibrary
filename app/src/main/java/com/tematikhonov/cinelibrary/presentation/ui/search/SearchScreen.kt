package com.tematikhonov.cinelibrary.presentation.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tematikhonov.cinelibrary.R
import com.tematikhonov.cinelibrary.presentation.components.search.*
import com.tematikhonov.cinelibrary.presentation.core.SearchField
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors
import com.tematikhonov.cinelibrary.domain.models.enumeration.SearchCategory.*
import com.tematikhonov.cinelibrary.presentation.components.ContentTitle

@Composable
fun SearchScreen(navController: NavHostController) {
    var query by remember { mutableStateOf("") }
    var chosenCategory by remember { mutableStateOf(ALL) }
    val viewModel = hiltViewModel<SearchViewModel>()
    val searchResultMovie = viewModel.searchMovie.observeAsState().value
    val searchResultPerson = viewModel.searchPerson.observeAsState().value

    Box(
        Modifier
            .fillMaxSize()
            .background(LocalCLBExtraColors.current.Dark)
            .padding(top = 24.dp)
    ) {
        Column(
            Modifier.padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            SearchField(
                Modifier.padding(top = 8.dp),
                value = query,
                input = query,
                onValueChange = {
                    query = it
                    if (query.isNotEmpty()) viewModel.initMovieAndPersonSearch(query)
                }, label = stringResource(
                    id = R.string.search_input_label
                )
            )
            Row(
                Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                SearchCategory(ALL, chosenCategory) { chosenCategory = ALL }
                SearchCategory(MOVIES, chosenCategory) { chosenCategory = MOVIES }
                SearchCategory(ACTORS, chosenCategory) { chosenCategory = ACTORS }
            }
            Spacer(Modifier.height(32.dp))
            when (chosenCategory) {
                ALL  -> {
                    if (searchResultMovie != null &&
                        searchResultPerson != null &&
                        query.isNotEmpty()
                    ) {
                        if (searchResultMovie.results.isEmpty() &&
                            searchResultPerson.results.isEmpty()) MovieNotFound()
                        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                            ContentTitle(text = stringResource(id = R.string.search_category_actors))
                            LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                                items(searchResultPerson.results) { item ->
                                    PersonSearchSmallItem(navController, item)
                                }
                            }
                            ContentTitle(text = stringResource(id = R.string.search_category_movies))
                            LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                                items(searchResultMovie.results) { item ->
                                    MovieSearchItem(navController, item)
                                }
                            }
                        }
                    }
                }
                MOVIES -> {
                    if (searchResultMovie != null && query.isNotEmpty()) {
                        if (searchResultMovie.results.isEmpty()) MovieNotFound()
                        LazyColumn {
                            items(searchResultMovie.results) { item ->
                                MovieSearchItem(navController, item)
                                Spacer(Modifier.height(16.dp))
                            }
                        }
                    }
                }
                ACTORS -> {
                    if (searchResultPerson != null && query.isNotEmpty()) {
                        if (searchResultPerson.results.isEmpty()) PersonNotFound()
                        LazyColumn {
                            items(searchResultPerson.results) { item ->
                                PersonSearchItem(navController, item)
                                Spacer(Modifier.height(16.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SearchScreenPreview() {
    val navController = rememberNavController()
    SearchScreen(navController)
}