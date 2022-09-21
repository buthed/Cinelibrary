package com.tematikhonov.cinelibrary.presentation.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tematikhonov.cinelibrary.R
import com.tematikhonov.cinelibrary.presentation.theme.CLBTypography
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors

@Composable
fun AboutUsScreen(navController: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(LocalCLBExtraColors.current.Dark)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_left),
                contentDescription = "",
                Modifier.clickable(onClick = { navController.popBackStack() }),
                tint = Color.White,
            )
            Text(text = stringResource(id = R.string.about_us), style = CLBTypography.h4)
            Icon(
                painter = painterResource(id = R.drawable.ic_share),
                contentDescription = "",
                tint = Color.Transparent,
            )
        }
    }
}

@Preview
@Composable
fun AboutUsScreenPreview() {
    val navController = rememberNavController()
    AboutUsScreen(navController)
}