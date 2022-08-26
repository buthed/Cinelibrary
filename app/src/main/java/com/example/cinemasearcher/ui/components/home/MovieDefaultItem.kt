package com.example.cinemasearcher.ui.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cinemasearcher.R
import com.example.cinemasearcher.data.model.entites.Result
import com.example.cinemasearcher.ui.theme.CLBTypography
import com.example.cinemasearcher.ui.theme.LocalCLBExtraColors

@Composable
fun MovieDefaultItem(data: Result) {
    Box(Modifier.width(150.dp).clip(RoundedCornerShape(8.dp))) {
        Column() {
            AsyncImage(model = R.drawable.posterexample, contentDescription = "")
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(LocalCLBExtraColors.current.Soft)
                    .padding(8.dp)
            ){
                Text(text = data.title,
                    style = CLBTypography.h4,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis)
                Text(text = "Action", style = CLBTypography.subtitle2)
            }
        }
        Box(
            Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
        ) {
            Card(
                Modifier
                    .width(55.dp)
                    .height(24.dp),
                backgroundColor = LocalCLBExtraColors.current.Soft,
                contentColor = LocalCLBExtraColors.current.Soft,
                shape = RoundedCornerShape(10.dp)
            ){
                Row(
                    Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = "",
                        Modifier.size(16.dp),
                        tint = LocalCLBExtraColors.current.Orange,
                    )
                    Spacer(Modifier.width(5.dp))
                    Text(
                        text = data.vote_average.toString(),
                        textAlign = TextAlign.End,
                        style = CLBTypography.body2,
                        color = LocalCLBExtraColors.current.Orange,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MovieDefaultItemPreview(){
    val item = Result(
        adult=false,
        backdrop_path="/jsoz1HlxczSuTx0mDl2h0lxy36l.jpg",
        genre_ids= listOf(28, 12, 14),
        id=616037,
        original_language="en",
        original_title="Thor: Love and Thunder, overview=After his retirement is interrupted by Gorr the God Butcher, a galactic killer who seeks the extinction of the gods, Thor Odinson enlists the help of King Valkyrie, Korg, and ex-girlfriend Jane Foster, who now inexplicably wields Mjolnir as the Relatively Mighty Girl Thor. Together they embark upon a harrowing cosmic adventure to uncover the mystery of the God Butcher’s vengeance and stop him before it’s too late.",
        overview = "",
        popularity=7172.102,
        poster_path="/pIkRyD18kl4FhoCNQuWxWu5cBLM.jpg",
        release_date= "2022-07-06",
        title="Thor: Love and Thunder",
        video=false,
        vote_average=6.8,
        vote_count=2034)

    MovieDefaultItem(item)
}

//TODO Add transparency to grades