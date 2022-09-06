package com.example.cinemasearcher.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cinemasearcher.R
import com.example.cinemasearcher.presentation.theme.CLBTypography
import com.example.cinemasearcher.presentation.theme.clbLightExtraColors

@Composable
fun ContentTitle(text:String) {
    Text(
        text = text,
        Modifier.padding(start = 24.dp),
        style = CLBTypography.h4,
        color = Color.White
    )
}

@Composable
fun ContentSeeAll() {
    Text(
        text = stringResource(id = R.string.home_see_all),
        Modifier.padding(end = 24.dp),
        style = CLBTypography.h4,
        color = clbLightExtraColors.BlueAccent)
}