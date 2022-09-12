package com.tematikhonov.cinelibrary.presentation.ui.auth

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tematikhonov.cinelibrary.presentation.NavItem
import com.tematikhonov.cinelibrary.presentation.components.ExtraLargeButton
import com.tematikhonov.cinelibrary.presentation.core.LoginTextField
import com.tematikhonov.cinelibrary.presentation.core.PasswordTextField
import com.tematikhonov.cinelibrary.presentation.theme.CLBTypography
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors
import com.tematikhonov.cinelibrary.utils.Resource

@Composable
fun SignUpScreen(navController: NavHostController) {
    val auth = Firebase.auth
    val viewModel = hiltViewModel<AuthViewModel>()
    val isSignIn =  viewModel.createUserWithEmailAndPassword.collectAsState()
    var passVisibility by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
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
            LoginTextField(onValueChange = {email = it}, label = "Login", value = email)
            Spacer(Modifier.height(24.dp))
            PasswordTextField(
                onValueChange = {password = it},
                label = "PlaceHolder",
                value = password,
                visualTransformation = if (passVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                passVisibility = { passVisibility = !passVisibility })
            Spacer(Modifier.height(24.dp))
            ExtraLargeButton("Sign up", {
                viewModel.createUserWithEmailAndPassword(email, password)
//                if (auth.currentUser!=null) navController.navigate(NavItem.MainScreen.navRoute)
//                Log.d("checkData", auth.currentUser.toString())
            },
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 24.dp),
                enabled = email.isNotEmpty() && password.isNotEmpty())
        }
    }
    isSignIn.value?.let {
        when (it) {
            is Resource.Failure -> {
                Toast.makeText(LocalContext.current, it.exception.message.toString(), Toast.LENGTH_LONG).show()
            }
            is Resource.Loading -> {
                CircularProgressIndicator(modifier = Modifier.fillMaxSize())
            }
            is Resource.Success -> {
                LaunchedEffect(Unit) {
                    navController.navigate(NavItem.MainScreen.navRoute)
                }
            }
        }
    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    val navController = rememberNavController()
    SignUpScreen(navController)
}