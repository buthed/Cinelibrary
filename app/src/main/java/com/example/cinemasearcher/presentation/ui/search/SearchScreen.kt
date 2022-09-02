package com.example.cinemasearcher.presentation.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cinemasearcher.R
import com.example.cinemasearcher.presentation.components.search.SearchCategory
import com.example.cinemasearcher.presentation.components.search.SearchItem
import com.example.cinemasearcher.presentation.core.SearchField
import com.example.cinemasearcher.presentation.theme.LocalCLBExtraColors

interface SearchScreenCallback{
    fun onSearch(query: String)
}

@Composable
fun SearchScreen(navController: NavHostController) {
    var query by remember { mutableStateOf("") }
    var chosenCategory by remember { mutableStateOf("All") }
    val viewModel = hiltViewModel<SearchViewModel>()
    val searchResult = viewModel.search.observeAsState().value

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
            SearchField(Modifier.padding(top = 8.dp),
                value = query,
                input = query,
                onValueChange = {
                    query = it
                    if (query.isNotEmpty()) viewModel.init(query)
                }, label = stringResource(
                    id = R.string.search_input_label
                ))
            Row(
                Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                SearchCategory(stringResource(id = R.string.search_category_all), chosenCategory,
                    onClick = { chosenCategory = R.string.search_category_all.toString()})
                SearchCategory(stringResource(id = R.string.search_category_movies), chosenCategory,
                    onClick ={ chosenCategory = R.string.search_category_movies.toString()})
                SearchCategory(stringResource(id = R.string.search_category_actors), chosenCategory,
                    onClick ={ chosenCategory = R.string.search_category_actors.toString()})
            }
            Spacer(Modifier.height(32.dp))
            if (searchResult!=null && query.isNotEmpty()) {
                LazyColumn{
                    items(searchResult.results) {item ->
                        SearchItem(navController,item)
                        Spacer(Modifier.height(16.dp))
                    }
                }
            }

        }

    }
}
//
//@Preview
//@Composable
//fun SearchScreenPreview() {
//    val navController = rememberNavController()
//    SearchScreen(navController)
//}