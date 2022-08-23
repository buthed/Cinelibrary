package com.example.cinemasearcher.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cinemasearcher.AppScreen
import com.example.cinemasearcher.ui.NavItem
import com.example.cinemasearcher.ui.screens.home.HomeScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavItem.Home.navRoute
    ) {
        composable(NavItem.Home.navRoute) {
            HomeScreen()
        }
        composable(NavItem.Search.navRoute) {
            AppScreen(text = "Home Screen")
        }
        composable(NavItem.Downloads.navRoute){
            AppScreen(text = "Home Screen")
        }
        composable(NavItem.Profile.navRoute) {
            AppScreen(text = "Home Screen")
        }
    }
}