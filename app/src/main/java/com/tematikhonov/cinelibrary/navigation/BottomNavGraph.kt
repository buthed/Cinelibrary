package com.tematikhonov.cinelibrary.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tematikhonov.cinelibrary.AppScreen
import com.tematikhonov.cinelibrary.presentation.NavItem
import com.tematikhonov.cinelibrary.presentation.ui.SplashScreen
import com.tematikhonov.cinelibrary.presentation.ui.auth.LoginScreen
import com.tematikhonov.cinelibrary.presentation.ui.auth.SignUpScreen
import com.tematikhonov.cinelibrary.presentation.ui.auth.WelcomeScreen
import com.tematikhonov.cinelibrary.presentation.ui.home.HomeScreen
import com.tematikhonov.cinelibrary.presentation.ui.main.MainScreen
import com.tematikhonov.cinelibrary.presentation.ui.movieDetails.AllGalleryScreen
import com.tematikhonov.cinelibrary.presentation.ui.movieDetails.MovieDetailsScreen
import com.tematikhonov.cinelibrary.presentation.ui.profile.ProfileScreen
import com.tematikhonov.cinelibrary.presentation.ui.search.SearchScreen

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
        composable(NavItem.Welcome.navRoute) {
            WelcomeScreen(navController = navController)
        }
        composable(NavItem.SignUp.navRoute){
            SignUpScreen(navController = navController)
        }
        composable(NavItem.Login.navRoute) {
            LoginScreen(navController = navController)
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
            ProfileScreen()
        }
        composable(route = "MovieDetails/{movieId}") { backStackEntry ->
            MovieDetailsScreen(movieId = backStackEntry.arguments?.getString("movieId")?: "555",
                navController = navController)
        }
        composable(route = "MovieDetailsGallery/{movieId}")  { backStackEntry ->
            AllGalleryScreen(movieId = backStackEntry.arguments?.getString("movieId")?: "555",
                navController = navController)
        }
    }
}