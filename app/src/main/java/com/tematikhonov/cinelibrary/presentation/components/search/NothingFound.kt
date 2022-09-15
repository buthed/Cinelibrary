package com.tematikhonov.cinelibrary.presentation.components.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematikhonov.cinelibrary.R
import com.tematikhonov.cinelibrary.presentation.theme.CLBTypography
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors


@Composable
fun NothingFound() {
    Column(
        Modifier.fillMaxSize().background(LocalCLBExtraColors.current.Dark).padding(top = 100.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(painter = painterResource(id = R.drawable.ic_no_results_colored), contentDescription = "")
        Spacer(Modifier.height(16.dp))
        Text(text = stringResource(id = R.string.search_not_found_title),
            style = CLBTypography.h4,
            textAlign = TextAlign.Center)
        Spacer(Modifier.height(8.dp))
        Text(text = stringResource(id = R.string.search_not_found_description),
            color = LocalCLBExtraColors.current.Gray,
            style = CLBTypography.body1,
            textAlign = TextAlign.Center)
    }
}

@Preview
@Composable
fun NothingFoundPreview() {
    NothingFound()
}