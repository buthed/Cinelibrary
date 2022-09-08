package com.tematikhonov.cinelibrary.presentation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.tematikhonov.cinelibrary.R

sealed class NavItem(
    val title: String,
    @DrawableRes val icon: Int = 0,
    val navRoute: String
) {
    object MainScreen: NavItem(NAV_MAIN, navRoute = NAV_MAIN)
    object Splash: NavItem(NAV_SPLASH, navRoute = NAV_SPLASH)
    object Welcome: NavItem(NAV_WELCOME, navRoute = NAV_WELCOME)
    object Login: NavItem(NAV_LOGIN, navRoute = NAV_LOGIN)
    object SignUp: NavItem(NAV_SIGN_UP, navRoute = NAV_SIGN_UP)
    object Home: NavItem(NAV_HOME, R.drawable.ic_home, NAV_HOME)
    object Search: NavItem(NAV_SEARCH, R.drawable.ic_search, NAV_SEARCH)
    object Downloads: NavItem(NAV_DOWNLOADS, R.drawable.ic_download, NAV_DOWNLOADS)
    object Profile: NavItem(NAV_PROFILE, R.drawable.ic_profile, NAV_PROFILE)
    object MovieDetails: NavItem(NAV_MOVIE, navRoute = NAV_MOVIE)
    object MovieDetailsGallery: NavItem(NAV_GALLERY, navRoute = NAV_GALLERY)
}
