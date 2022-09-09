package com.tematikhonov.cinelibrary.presentation.ui.auth

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
fun LoginScreen(navController: NavHostController) {
    val auth = Firebase.auth
    val viewModel = hiltViewModel<AuthViewModel>()
    val isSignIn =  viewModel.firebaseSignInWithEmailAndPassword.collectAsState()
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Box(Modifier.fillMaxSize().background(LocalCLBExtraColors.current.Dark)
    ){
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)) {
            Spacer(Modifier.height(24.dp))
            Text(text = "Login",
                Modifier.fillMaxWidth(),
                style = CLBTypography.h2,
                color = Color.White,
                textAlign = TextAlign.Center)
            Spacer(Modifier.height(24.dp))
            LoginTextField(onValueChange = {login = it}, label = "Login", value = login)
            Spacer(Modifier.height(24.dp))
            PasswordTextField(onValueChange = {password = it}, label = "PlaceHolder", value = password)
            Spacer(Modifier.height(24.dp))
            Button(onClick = {
                Log.d("checkData", "UID is " + auth.currentUser?.uid.toString())
                viewModel.firebaseSignInWithEmailAndPassword(login, password)
            },
            enabled = login.isNotEmpty() && password.isNotEmpty()
            ) {
                Text(text = "Login")
            }
            ExtraLargeButton("Login", onClick = {

            },
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 24.dp))
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
                    navController.navigate(NavItem.Home.navRoute)
                }
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController()
    LoginScreen(navController)
}