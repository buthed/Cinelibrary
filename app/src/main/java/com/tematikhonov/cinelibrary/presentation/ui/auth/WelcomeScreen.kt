package com.tematikhonov.cinelibrary.presentation.ui.auth

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tematikhonov.cinelibrary.R
import com.tematikhonov.cinelibrary.presentation.NavItem
import com.tematikhonov.cinelibrary.presentation.components.ExtraLargeButton
import com.tematikhonov.cinelibrary.presentation.theme.CLBTypography
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors


@Composable
fun WelcomeScreen(navController: NavHostController) {
    val viewModel = hiltViewModel<AuthViewModel>()
    Box(
        Modifier
            .fillMaxSize()
            .background(LocalCLBExtraColors.current.Dark),
        contentAlignment = Alignment.Center
    ){
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(id = R.string.app_name),
                Modifier.width(170.dp).padding(bottom = 10.dp)
            )
            Text(
                text = stringResource(id = R.string.app_name),
                color = LocalCLBExtraColors.current.BlueAccent,
                textAlign = TextAlign.Center,
                fontSize = 40.sp,
                fontFamily = FontFamily(Font(R.font.fightclub_font)),
            )
            Spacer(Modifier.height(24.dp))
            Text(text = stringResource(id = R.string.welcome_sign_up_enter),
                Modifier.fillMaxWidth(),
                style = CLBTypography.h5,
                color = LocalCLBExtraColors.current.Gray,
                textAlign = TextAlign.Center)
            Spacer(Modifier.height(24.dp))
            ExtraLargeButton(text = stringResource(id = R.string.welcome_sign_up),
                onClick = { navController.navigate(NavItem.SignUp.navRoute)},
                enabled = true)
            Spacer(Modifier.height(24.dp))
            Row() {
                Text(text = stringResource(id = R.string.welcome_already_have_an_account),
                    style = CLBTypography.h5,
                    color = LocalCLBExtraColors.current.Gray)
                Text(text = stringResource(id = R.string.welcome_login),
                    Modifier.clickable(onClick = {  navController.navigate(NavItem.Login.navRoute)}),
                    style = CLBTypography.h5,
                    color = LocalCLBExtraColors.current.BlueAccent)
            }
            Spacer(Modifier.height(16.dp))
            Row(Modifier.fillMaxWidth().padding(vertical = 32.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Divider(color = LocalCLBExtraColors.current.Soft,
                    modifier = Modifier
                        .width(80.dp)
                        .padding(horizontal = 8.dp),
                    thickness = 1.dp)
                Text(text = stringResource(id = R.string.welcome_or_sign_up),
                    style = CLBTypography.h5,
                    color = LocalCLBExtraColors.current.Gray,
                    textAlign = TextAlign.Center)
                Divider(color = LocalCLBExtraColors.current.Soft,
                    modifier = Modifier
                        .width(80.dp)
                        .padding(horizontal = 8.dp),
                    thickness = 1.dp)
            }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(painter = painterResource(id = R.drawable.icon_email), contentDescription = "",
                    Modifier.size(70.dp).clickable(onClick = {}))
                Image(painter = painterResource(id = R.drawable.icon_google), contentDescription = "",
                    Modifier.size(70.dp).clickable(onClick = {}))
                Image(painter = painterResource(id = R.drawable.icon_twitter), contentDescription = "",
                    Modifier.size(70.dp).clickable(onClick = {}))
                Image(painter = painterResource(id = R.drawable.icon_facebook), contentDescription = "",
                    Modifier.size(70.dp).clickable(onClick = {}))
            }
        }


    }
}

@Preview
@Composable
fun WelcomeScreenPreview(){
    val navController = rememberNavController()
    WelcomeScreen(navController)
}