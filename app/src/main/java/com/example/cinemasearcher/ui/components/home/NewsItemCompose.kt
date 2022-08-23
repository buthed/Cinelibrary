package com.example.cinemasearcher.ui.components.home

import android.icu.number.Scale
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ContentScale.Companion.Fit
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemasearcher.R
import com.example.cinemasearcher.ui.theme.CLBTypography
import com.example.cinemasearcher.ui.theme.LocalCLBExtraColors

@Composable
fun NewsItem() {
    Card(
        Modifier
            .height(154.dp)
            .width(274.dp)
            .clip(RoundedCornerShape(16.dp))) {
        Image(
            painter = painterResource(id = R.drawable.backdropsexample),
            contentDescription = "",
            Modifier.fillMaxSize(),
)
        Box(
            Modifier
                .height(154.dp)
                .padding(16.dp),
            contentAlignment = Alignment.BottomStart){
            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.Start,) {
                Text(text = "Black Panther: Wakanda Forever", style = CLBTypography.h4)
                Spacer(Modifier.height(4.dp))
                Text(text = "On March 2, 2022", style = CLBTypography.body2)
            }
        }
    }
}

@Preview
@Composable
fun NewsItemPreview() {
    NewsItem()
}

//TODO Add View pager