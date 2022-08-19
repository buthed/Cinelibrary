package com.example.cinemasearcher.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.cinemasearcher.R

sealed class NavItem(
    @StringRes val title: Int,
    @DrawableRes val  icon: Int,
    val navRoute: String
) {
    object Home: NavItem(R.string.home,R.drawable.ic_home, NAV_HOME)
    object Search: NavItem(R.string.search,R.drawable.ic_search, NAV_SEARCH)
    object Downloads: NavItem(R.string.downloads,R.drawable.ic_download, NAV_DOWNLOADS)
    object Profile: NavItem(R.string.profile,R.drawable.ic_profile, NAV_PROFILE)
}
