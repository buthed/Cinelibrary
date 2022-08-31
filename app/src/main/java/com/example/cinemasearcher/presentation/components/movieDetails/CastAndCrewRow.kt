package com.example.cinemasearcher.presentation.components.movieDetails

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cinemasearcher.domain.models.ApiConstants.TMDB_IMAGE_PATH
import com.example.cinemasearcher.domain.models.entites.Cast
import com.example.cinemasearcher.presentation.theme.CLBTypography

@Composable
fun CastAndCrewRow(modifier: Modifier = Modifier, cast: List<Cast>) {
    LazyRow(modifier = modifier){
        items(cast) { item ->
            CastAndCrewRowItem(item)
        }

    }
}

@Composable
fun CastAndCrewRowItem(person: Cast) {
    Row(){
        AsyncImage(
            modifier = Modifier
                .size(40.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop,
            model = TMDB_IMAGE_PATH+person.profile_path,
            contentDescription = "",
        )
        Column(Modifier.padding(start = 8.dp)) {
            Text(person.name, style = CLBTypography.h5, color = Color.White)
            Text(person.known_for_department, style = CLBTypography.subtitle2)
        }
        Spacer(Modifier.width(12.dp))
    }
}

//@Preview
//@Composable
//fun CastAndCrewItemPreview(){
//    CastAndCrewRowItem(item)
//}

//@Preview
//@Composable
//fun CastAndCrewRowPreview(){
//    CastAndCrewRow(cast = credits.cast)
//}