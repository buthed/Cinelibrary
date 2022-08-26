package com.example.cinemasearcher.ui.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.cinemasearcher.ui.NavItem
import com.example.cinemasearcher.ui.components.BottomBar
import com.example.cinemasearcher.navigation.BottomNavGraph
import com.example.cinemasearcher.viewmodel.MainViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val viewModel = hiltViewModel<MainViewModel>()
    LaunchedEffect(key1 = true) {
        navController.navigate(NavItem.Home.navRoute)
    }
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        Modifier.padding(it)
        BottomNavGraph(
            navController = navController,
            viewModel = viewModel
        )
    }
}

@Composable
@Preview
fun BottomNavPreview() {
    MainScreen()
}
