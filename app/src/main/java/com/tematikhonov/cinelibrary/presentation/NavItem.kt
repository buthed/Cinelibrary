package com.tematikhonov.cinelibrary.presentation

import androidx.annotation.DrawableRes
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
    object Favorites: NavItem(NAV_FAVORITES, R.drawable.ic_heart, NAV_FAVORITES)
    object Profile: NavItem(NAV_PROFILE, R.drawable.ic_profile, NAV_PROFILE)
    object MovieDetails: NavItem(NAV_MOVIE, navRoute = NAV_MOVIE)
    object MovieDetailsGallery: NavItem(NAV_GALLERY, navRoute = NAV_GALLERY)
    object Person: NavItem(NAV_PERSON, navRoute =  NAV_PERSON)
    object Language: NavItem(NAV_LANGUAGE, navRoute = NAV_LANGUAGE)
    object Policies: NavItem(NAV_POLICIES, navRoute = NAV_POLICIES)
    object Help: NavItem(NAV_HELP, navRoute = NAV_HELP)
    object About: NavItem(NAV_ABOUT, navRoute = NAV_ABOUT)
}
