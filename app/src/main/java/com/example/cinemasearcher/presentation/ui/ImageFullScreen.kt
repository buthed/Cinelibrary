package com.example.cinemasearcher.presentation.ui

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
import com.example.cinemasearcher.R
import com.example.cinemasearcher.domain.models.entites.Movie
import com.example.cinemasearcher.presentation.theme.CLBTypography

@Composable
fun ImageFullScreen(movie: Movie, navController: NavHostController) {
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
                Modifier.clickable(onClick = {navController.popBackStack()}),
                tint = Color.White,)
            Column() {
                Text(text = movie.title, style = CLBTypography.h4)
                Text(text = stringResource(id = R.string.movie_images), style = CLBTypography.subtitle1)
            }
            Icon(painter = painterResource(id = R.drawable.ic_share), contentDescription = "", tint = Color.Red)
        }
    }
}

//@Preview
//@Composable
//fun ImageFullScreenPreview() {
//    ImageFullScreen()
//}