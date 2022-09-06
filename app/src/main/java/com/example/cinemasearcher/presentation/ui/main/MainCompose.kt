package com.example.cinemasearcher.presentation.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cinemasearcher.navigation.NavHost
import com.example.cinemasearcher.presentation.NAV_GALLERY
import com.example.cinemasearcher.presentation.NAV_MOVIE
import com.example.cinemasearcher.presentation.NAV_SEARCH
import com.example.cinemasearcher.presentation.NavItem
import com.example.cinemasearcher.presentation.components.BottomBar
import com.example.cinemasearcher.presentation.ui.home.HomeViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    var showBottomBar by rememberSaveable { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    showBottomBar =  when (navBackStackEntry?.destination?.route) {
        NAV_MOVIE -> false
        NAV_GALLERY -> false
        else -> true
    }

    LaunchedEffect(key1 = true) {
        navController.navigate(NavItem.Home.navRoute)
    }
    Scaffold(
        bottomBar = { if (showBottomBar) BottomBar(navController = navController) }
    ) {
        Modifier.padding(it)
        NavHost(
            navController = navController,
        )
    }


}

@Composable
@Preview
fun BottomNavPreview() {
    MainScreen()
}
