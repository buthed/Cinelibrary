package com.example.cinemasearcher.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cinemasearcher.AppScreen
import com.example.cinemasearcher.ui.NavItem
import com.example.cinemasearcher.ui.screens.SplashScreen
import com.example.cinemasearcher.ui.screens.home.HomeScreen
import com.example.cinemasearcher.ui.screens.main.MainScreen
import com.example.cinemasearcher.viewmodel.HomeViewModel

@Composable
fun NavHost(navController: NavHostController, viewModel: HomeViewModel) {

    NavHost(
        navController = navController,
        startDestination = NavItem.Splash.navRoute
    ) {
        composable(NavItem.MainScreen.navRoute) {
            MainScreen()
        }
        composable(NavItem.Splash.navRoute) {
            SplashScreen(navController = navController,viewModel)
        }
        composable(NavItem.Home.navRoute) {
            HomeScreen(viewModel)
        }
        composable(NavItem.Search.navRoute) {
            AppScreen(text = "Search Screen")
        }
        composable(NavItem.Downloads.navRoute){
            AppScreen(text = "Downloads Screen")
        }
        composable(NavItem.Profile.navRoute) {
            AppScreen(text = "Profile Screen")
        }
    }
}