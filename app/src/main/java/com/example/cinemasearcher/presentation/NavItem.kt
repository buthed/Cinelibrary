package com.example.cinemasearcher.presentation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.cinemasearcher.R

sealed class NavItem(
    @StringRes val title: Int,
    @DrawableRes val  icon: Int = 0,
    val navRoute: String
) {
    object MainScreen: NavItem(R.string.splash,R.drawable.logo,NAV_MAIN)
    object Splash: NavItem(R.string.splash, navRoute = NAV_SPLASH)
    object Home: NavItem(R.string.home,R.drawable.ic_home, NAV_HOME)
    object Search: NavItem(R.string.search,R.drawable.ic_search, NAV_SEARCH)
    object Downloads: NavItem(R.string.downloads,R.drawable.ic_download, NAV_DOWNLOADS)
    object Profile: NavItem(R.string.profile,R.drawable.ic_profile, NAV_PROFILE)
    object MovieDetails: NavItem(R.string.movieDetails,navRoute = NAV_MOVIE)
    object MovieDetailsGallery: NavItem(R.string.movieDetailsGallery,navRoute = NAV_GALLERY)
}
