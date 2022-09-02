package com.example.cinemasearcher.presentation.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.cinemasearcher.R
import com.example.cinemasearcher.presentation.theme.CLBTypography
import com.example.cinemasearcher.presentation.theme.LocalCLBExtraColors

@Composable
fun ProfileScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(LocalCLBExtraColors.current.Dark)
    ) {
        Text(text = stringResource(id = R.string.profile), style = CLBTypography.h4, textAlign = TextAlign.Center)

    }    
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}