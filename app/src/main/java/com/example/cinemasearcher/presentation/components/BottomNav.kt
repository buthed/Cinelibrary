package com.example.cinemasearcher.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.cinemasearcher.presentation.NavItem
import com.example.cinemasearcher.presentation.theme.LocalCLBExtraColors

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        NavItem.Home,
        NavItem.Search,
        NavItem.Downloads,
        NavItem.Profile
    )

    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination

    Row(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp)
            .background(Color.Transparent)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }

}

@Composable
fun RowScope.AddItem(
    screen: NavItem,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.navRoute } == true
    val color = if (selected) LocalCLBExtraColors.current.Soft
    else Color.Black.copy(alpha = 0f)

    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color)
            .clickable(onClick = {
                navController.navigate(screen.navRoute) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            })
    ) {
        Row(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp),

        ) {
            Icon(
                painter = painterResource(id = if (selected) screen.icon else screen.icon),
                contentDescription = "icon",
                tint = LocalCLBExtraColors.current.Gray
            )
            AnimatedVisibility(visible = selected) {
                Text(
                    text = stringResource(id = screen.title),
                    color = LocalCLBExtraColors.current.Gray
                )
            }
        }
    }
}


