package com.example.cinemasearcher.presentation.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cinemasearcher.R
import com.example.cinemasearcher.presentation.NavItem
import com.example.cinemasearcher.presentation.theme.LocalCLBExtraColors
import com.example.cinemasearcher.presentation.ui.home.HomeViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    var startAnimate by remember {
        mutableStateOf(false)
    }
    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimate) 1f else 0f,
        animationSpec = tween(durationMillis = 3000)
    )
    LaunchedEffect(key1 = true) {
        startAnimate = true
        delay(3000)
        navController.navigate(NavItem.MainScreen.navRoute)
    }
    Splash(alphaAnimation.value)
}

@Composable
fun Splash(alpha: Float) {
    Box(Modifier.fillMaxSize().background(LocalCLBExtraColors.current.Dark),
        contentAlignment = Alignment.Center
    ) {
        Column(
            Modifier.alpha(alpha),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(id = R.string.app_name),
                Modifier.width(170.dp).padding(bottom = 20.dp)
            )
            Text(
                text = stringResource(id = R.string.app_name),
                color = LocalCLBExtraColors.current.BlueAccent,
                textAlign = TextAlign.Center,
                fontSize = 40.sp,
                fontFamily = FontFamily(Font(R.font.fightclub_font)),
            )
        }
    }

}

@Preview
@Composable
fun SplashScreenPreview() {
    var startAnimate by remember {
        mutableStateOf(false)
    }
    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimate) 1f else 0f,
        animationSpec = tween(durationMillis = 3000)
    )
    Splash(alphaAnimation.value)
}