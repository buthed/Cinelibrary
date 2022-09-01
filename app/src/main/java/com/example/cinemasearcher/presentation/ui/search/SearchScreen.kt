package com.example.cinemasearcher.presentation.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemasearcher.R
import com.example.cinemasearcher.presentation.components.search.SearchCategory
import com.example.cinemasearcher.presentation.core.SearchField
import com.example.cinemasearcher.presentation.theme.LocalCLBExtraColors

@Composable
fun SearchScreen() {
    var chosenCategory by remember { mutableStateOf("All") }

    Box(Modifier.fillMaxSize().background(LocalCLBExtraColors.current.Dark).padding(top = 24.dp)
    ) {
        Column(
            Modifier.padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            SearchField(Modifier.padding(top = 8.dp),
                input = "",
                onValueChange = {}, label = stringResource(
                    id = R.string.search_input_label
                ))
            Row(
                Modifier.padding(top = 24.dp).fillMaxWidth(),
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
        }
    }
}

@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen()
}