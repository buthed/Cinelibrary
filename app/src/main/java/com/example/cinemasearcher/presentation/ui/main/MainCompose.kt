package com.example.cinemasearcher.presentation.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.cinemasearcher.navigation.NavHost
import com.example.cinemasearcher.presentation.NavItem
import com.example.cinemasearcher.presentation.components.BottomBar
import com.example.cinemasearcher.presentation.ui.home.HomeViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val viewModel = hiltViewModel<HomeViewModel>()
    LaunchedEffect(key1 = true) {
        navController.navigate(NavItem.Home.navRoute)
    }
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        Modifier.padding(it)
        NavHost(
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
