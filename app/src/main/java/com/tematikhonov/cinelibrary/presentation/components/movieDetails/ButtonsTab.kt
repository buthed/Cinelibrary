package com.tematikhonov.cinelibrary.presentation.components.movieDetails

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematikhonov.cinelibrary.R
import com.tematikhonov.cinelibrary.presentation.components.RoundedPlayButton
import com.tematikhonov.cinelibrary.presentation.theme.CLBColors
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors

@Composable
fun ButtonsTab(modifier: Modifier = Modifier, share: () -> Unit = {}, playTrailer: () -> Unit = {}, trailerLink: String) {
    Row(modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        RoundedPlayButton("Play",
            Modifier.padding(vertical = 4.dp, horizontal = 24.dp),
            onClick = playTrailer,
            ButtonDefaults.buttonColors(
                backgroundColor = if (trailerLink.isNotEmpty()) LocalCLBExtraColors.current.Orange else LocalCLBExtraColors.current.DarkGray,
            )
        )
        Spacer(Modifier.width(16.dp))
        Button(onClick = {},
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
            onClick = share,
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
    ButtonsTab(Modifier,{}, {  }, "")
}