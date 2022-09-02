package com.example.cinemasearcher.presentation.components.movieDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemasearcher.R
import com.example.cinemasearcher.presentation.theme.CLBTypography
import com.example.cinemasearcher.presentation.theme.LocalCLBExtraColors

@Composable
fun ShareLinkToSocialMedia(close: () -> Unit) {
    Box(
        Modifier
            .fillMaxSize()
            .background(LocalCLBExtraColors.current.Soft.copy(0.85f))
            .blur(40.dp)
            .padding(horizontal = 24.dp).clickable(onClick = close),
        contentAlignment = Alignment.Center
    ){
        Column(Modifier
                .fillMaxWidth()
                .background(LocalCLBExtraColors.current.Soft)
                .heightIn(200.dp)
                .clickable {  }
                .clip(RoundedCornerShape(16.dp)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End,
        ) {
            Image(painter = painterResource(id = R.drawable.ic_close),
                contentDescription = "",
                Modifier.padding(end = 24.dp).clickable(onClick = close),
                alignment = Alignment.TopEnd)
            Column(Modifier.fillMaxWidth().padding(horizontal = 32.dp)) {
                Text(text = stringResource(id = R.string.movie_share_to),
                    Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = CLBTypography.h3,
                    color = Color.White)
                Divider(color = LocalCLBExtraColors.current.Dark,
                    modifier = Modifier
                        .fillMaxWidth().padding(vertical = 32.dp),
                    thickness = 1.dp)
                Row(Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(painter = painterResource(id = R.drawable.icon_share_link), contentDescription = "", Modifier.size(50.dp))
                    Image(painter = painterResource(id = R.drawable.icon_facebook), contentDescription = "", Modifier.size(50.dp))
                    Image(painter = painterResource(id = R.drawable.icon_instagram), contentDescription = "", Modifier.size(50.dp))
                    Image(painter = painterResource(id = R.drawable.icon_telegram), contentDescription = "", Modifier.size(50.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun ShareLinkToSocialMediaPreview() {
    ShareLinkToSocialMedia({})
}