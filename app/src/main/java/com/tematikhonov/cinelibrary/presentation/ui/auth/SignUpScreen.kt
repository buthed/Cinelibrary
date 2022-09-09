package com.tematikhonov.cinelibrary.presentation.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tematikhonov.cinelibrary.presentation.components.ExtraLargeButton
import com.tematikhonov.cinelibrary.presentation.core.LoginTextField
import com.tematikhonov.cinelibrary.presentation.core.PasswordTextField
import com.tematikhonov.cinelibrary.presentation.theme.CLBTypography
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors

@Composable
fun SignUpScreen(navController: NavHostController) {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Box(
        Modifier
            .fillMaxSize()
            .background(LocalCLBExtraColors.current.Dark)){
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)) {
            Spacer(Modifier.height(24.dp))
            Text(text = "Sign Up",
                Modifier.fillMaxWidth(),
                style = CLBTypography.h2,
                color = Color.White,
                textAlign = TextAlign.Center)
            Spacer(Modifier.height(24.dp))
            LoginTextField(onValueChange = {login = it}, label = "Login", value = login)
            Spacer(Modifier.height(24.dp))
            PasswordTextField(onValueChange = {password = it}, label = "PlaceHolder", value = password)
            Spacer(Modifier.height(24.dp))
            ExtraLargeButton("Sign up", {},
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 24.dp))
        }


    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    val navController = rememberNavController()
    SignUpScreen(navController)
}