package com.example.cinemasearcher.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cinemasearcher.AppScreen
import com.example.cinemasearcher.presentation.NavItem
import com.example.cinemasearcher.presentation.ui.SplashScreen
import com.example.cinemasearcher.presentation.ui.home.HomeScreen
import com.example.cinemasearcher.presentation.ui.main.MainScreen
import com.example.cinemasearcher.presentation.ui.home.HomeViewModel
import com.example.cinemasearcher.presentation.ui.movieDetails.MovieDetailsScreen
import com.example.cinemasearcher.presentation.ui.search.SearchScreen

@Composable
fun NavHost(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = NavItem.Splash.navRoute
    ) {
        composable(NavItem.MainScreen.navRoute) {
            MainScreen()
        }
        composable(NavItem.Splash.navRoute) {
            SplashScreen(navController = navController)
        }
        composable(NavItem.Home.navRoute) {
            HomeScreen(navController = navController)
        }
        composable(NavItem.Search.navRoute) {
            SearchScreen(navController = navController)
        }
        composable(NavItem.Downloads.navRoute){
            AppScreen(text = "Downloads Screen")
        }
        composable(NavItem.Profile.navRoute) {
            AppScreen(text = "Profile Screen")
        }
        composable(route = "MovieDetails/{movieId}") { backStackEntry ->
            MovieDetailsScreen(movieId = backStackEntry.arguments?.getString("movieId")?: "555",
                navController = navController)
        }
    }
}