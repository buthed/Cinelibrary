package com.tematikhonov.cinelibrary.presentation.ui.profile

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.tematikhonov.cinelibrary.presentation.ui.auth.AuthViewModel

@Composable
fun ProfileScreen() {
    val viewModel = hiltViewModel<AuthViewModel>()

    Button(onClick = {
        viewModel.signOut()
    }) {
        Text(text = "Log out")
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}