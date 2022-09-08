package com.tematikhonov.cinelibrary.presentation.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tematikhonov.cinelibrary.presentation.NavItem
import com.tematikhonov.cinelibrary.presentation.theme.CLBTypography
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors


@Composable
fun WelcomeScreen(navController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(LocalCLBExtraColors.current.Dark)){
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)) {
            Spacer(Modifier.height(24.dp))
            Text(text = "Welcome",
                Modifier.fillMaxWidth(),
                style = CLBTypography.h2,
                color = Color.White,
                textAlign = TextAlign.Center)
            Spacer(Modifier.height(24.dp))
            Button(onClick = {
                navController.navigate(NavItem.Login.navRoute)
            }) {
                Text(text = "Log in")
            }
            Spacer(Modifier.height(24.dp))
            Button(onClick = {
                navController.navigate(NavItem.SignUp.navRoute)
            }) {
                Text(text = "Sign UP")
            }
            Spacer(Modifier.height(24.dp))
        }


    }
}

@Preview
@Composable
fun WelcomeScreenPreview(){
    val navController = rememberNavController()
    WelcomeScreen(navController)
}