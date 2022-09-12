package com.tematikhonov.cinelibrary.presentation.ui.auth

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tematikhonov.cinelibrary.R
import com.tematikhonov.cinelibrary.presentation.components.ExtraLargeButton
import com.tematikhonov.cinelibrary.presentation.core.LoginTextField
import com.tematikhonov.cinelibrary.presentation.core.PasswordTextField
import com.tematikhonov.cinelibrary.presentation.theme.CLBTypography
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors

@Composable
fun ResetPasswordScreen() {
    var login by remember { mutableStateOf("") }
    Box(
        Modifier
            .fillMaxSize()
            .background(LocalCLBExtraColors.current.Dark)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Box(contentAlignment = Alignment.TopCenter) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = "",
                        //Modifier.clickable {navController.popBackStack()},
                        tint = Color.White,
                    )
                    Text(text = stringResource(id = R.string.login_title), style = CLBTypography.h4)
                    Icon(
                        painter = painterResource(id = R.drawable.ic_heart),
                        contentDescription = "",
                        tint = Color.Transparent
                    )
                }
            }
            Spacer(Modifier.height(40.dp))
            Text(
                text = stringResource(id = R.string.reset_title),
                Modifier.fillMaxWidth(),
                style = CLBTypography.h2,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(id = R.string.reset_description),
                Modifier.fillMaxWidth(),
                style = CLBTypography.body1,
                color = LocalCLBExtraColors.current.Whiter,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(64.dp))
            LoginTextField(
                onValueChange = { login = it },
                label = stringResource(id = R.string.login_email_label),
                value = login
            )
            Spacer(Modifier.height(24.dp))
            Spacer(Modifier.height(40.dp))
            ExtraLargeButton(
                text = stringResource(id = R.string.reset_button),
                onClick = {
//                    Log.d("checkData", "UID is " + auth.currentUser?.uid.toString())
//                    viewModel.firebaseSignInWithEmailAndPassword(login, password)
                },
                enabled = login.isNotEmpty()
            )
        }
    }
}

@Preview
@Composable
fun ResetPasswordScreenPreview() {
    ResetPasswordScreen()
}