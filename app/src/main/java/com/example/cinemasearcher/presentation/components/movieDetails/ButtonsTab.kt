package com.example.cinemasearcher.presentation.components.movieDetails

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemasearcher.R
import com.example.cinemasearcher.presentation.core.ExtraLargePlayButton
import com.example.cinemasearcher.presentation.theme.CLBColors
import com.example.cinemasearcher.presentation.theme.LocalCLBExtraColors

@Composable
fun ButtonsTab(modifier: Modifier = Modifier) {
    Row(modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        ExtraLargePlayButton(stringResource(id = R.string.movie_play),{})
        Spacer(Modifier.width(16.dp))
        Button(
            onClick = { /*TODO*/ },
            Modifier.size(48.dp),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = LocalCLBExtraColors.current.Soft
            )) {
            Icon(
                painter = painterResource(id = R.drawable.ic_download),
                contentDescription = "",
                Modifier.size(20.dp),
                tint = LocalCLBExtraColors.current.Orange,
            )
        }
        Spacer(Modifier.width(16.dp))
        Button(
            onClick = { /*TODO*/ },
            Modifier.size(48.dp),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = LocalCLBExtraColors.current.Soft
            )) {
            Icon(painter = painterResource(id = R.drawable.ic_share),
                contentDescription = "",
                Modifier.size(20.dp),
                tint = CLBColors.primary,
            )
        }

    }
}

@Preview
@Composable
fun ButtonsTabPreview() {
    ButtonsTab()
}