package com.tematikhonov.cinelibrary.presentation.ui.profile

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tematikhonov.cinelibrary.presentation.NavItem
import com.tematikhonov.cinelibrary.presentation.ui.auth.AuthViewModel

@Composable
fun ProfileScreen(navController: NavHostController) {
    val viewModel = hiltViewModel<AuthViewModel>()

    Button(onClick = {
        viewModel.signOut()
        navController.navigate(NavItem.Welcome.navRoute)
    }) {
        Text(text = "Log out")
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    val navController = rememberNavController()
    ProfileScreen(navController)
}