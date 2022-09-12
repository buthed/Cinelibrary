package com.tematikhonov.cinelibrary.presentation.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tematikhonov.cinelibrary.navigation.NavHost
import com.tematikhonov.cinelibrary.presentation.NAV_GALLERY
import com.tematikhonov.cinelibrary.presentation.NAV_MOVIE
import com.tematikhonov.cinelibrary.presentation.NavItem
import com.tematikhonov.cinelibrary.presentation.components.BottomBar

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    var showBottomBar by rememberSaveable { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    showBottomBar =  when (navBackStackEntry?.destination?.route) {
        NAV_MOVIE -> false

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
