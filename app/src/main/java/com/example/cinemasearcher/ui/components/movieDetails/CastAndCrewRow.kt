package com.example.cinemasearcher.ui.components.movieDetails

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cinemasearcher.ui.theme.CLBTypography

@Composable
fun CastAndCrewRow(modifier:Modifier = Modifier) {
    val data: List<String> = listOf("1","2","3","4")
    LazyRow(modifier = modifier){
        items(data.size){item ->
            CastAndCrewRowItem()
        }
    }
}

@Composable
fun CastAndCrewRowItem() {
    Row(){
        AsyncImage(
            modifier = Modifier
                .size(40.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop,
            model = "https://upload.wikimedia.org/wikipedia/commons/0/0b/Quentin_Tarantino_by_Gage_Skidmore.jpg",
            contentDescription = "",
        )
        Column(Modifier.padding(start = 8.dp)) {
            Text("John Watts", style = CLBTypography.h5, color = Color.White)
            Text("Director", style = CLBTypography.subtitle2)
        }
        Spacer(Modifier.width(12.dp))
    }
}

@Preview
@Composable
fun CastAndCrewItemPreview(){
    CastAndCrewRowItem()
}

@Preview
@Composable
fun CastAndCrewRowPreview(){
    CastAndCrewRow()
}