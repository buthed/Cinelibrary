package com.tematikhonov.cinelibrary.presentation.ui.auth

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
import com.tematikhonov.cinelibrary.R
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
    var passVisibility by remember { mutableStateOf(false) }
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Box(
        Modifier
            .fillMaxSize()
            .background(LocalCLBExtraColors.current.Dark)
    ){
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Box(contentAlignment = Alignment.TopCenter){
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top,
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = "",
                        Modifier.clickable {navController.popBackStack()},
                        tint = Color.White,)
                    Text(text = stringResource(id = R.string.login_title), style = CLBTypography.h4)
                    Icon(painter = painterResource(id = R.drawable.ic_heart), contentDescription = "", tint = Color.Transparent)
                }
            }
            Spacer(Modifier.height(40.dp))
            Text(text = stringResource(id = R.string.login_hi),
                Modifier.fillMaxWidth(),
                style = CLBTypography.h2,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center)
            Text(text = stringResource(id = R.string.login_welcome_back),
                Modifier.fillMaxWidth(),
                style = CLBTypography.body1,
                color = LocalCLBExtraColors.current.Whiter,
                textAlign = TextAlign.Center)
            Spacer(Modifier.height(64.dp))
            LoginTextField(onValueChange = {login = it},
                label = stringResource(id = R.string.login_email_label),
                value = login)
            Spacer(Modifier.height(24.dp))
            PasswordTextField(onValueChange = {password = it},
                label = stringResource(id = R.string.login_password_label),
                value = password,
                visualTransformation = if (passVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                passVisibility = { passVisibility = !passVisibility }
            )
            Spacer(Modifier.height(8.dp))
            Text(text = stringResource(id = R.string.login_forgot_password),
                Modifier
                    .fillMaxWidth()
                    .clickable(onClick = {}),
                style = CLBTypography.body1,
                color = LocalCLBExtraColors.current.BlueAccent,
                textAlign = TextAlign.End)
            Spacer(Modifier.height(40.dp))
            ExtraLargeButton(text = stringResource(id = R.string.login_title),
                onClick = {
                    Log.d("checkData", "UID is " + auth.currentUser?.uid.toString())
                    viewModel.firebaseSignInWithEmailAndPassword(login, password)
                },
                enabled = login.isNotEmpty() && password.isNotEmpty()
            )
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
fun LoginScreenPreview() {
    val navController = rememberNavController()
    LoginScreen(navController)
}