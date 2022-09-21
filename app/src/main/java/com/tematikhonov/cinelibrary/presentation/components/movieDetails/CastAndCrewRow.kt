package com.tematikhonov.cinelibrary.presentation.components.movieDetails

import androidx.compose.foundation.clickable
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
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.tematikhonov.cinelibrary.R
import com.tematikhonov.cinelibrary.domain.models.ApiConstants.TMDB_IMAGE_PATH
import com.tematikhonov.cinelibrary.domain.models.entites.Cast
import com.tematikhonov.cinelibrary.presentation.theme.CLBTypography

@Composable
fun CastAndCrewRow(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    cast: List<Cast>
) {
    LazyRow(modifier = modifier){
        items(cast) { item ->
            CastAndCrewRowItem(item, navController)
        }

    }
}

@Composable
fun CastAndCrewRowItem(person: Cast, navController: NavHostController) {
     Row(Modifier.clickable(onClick = {navController.navigate("Person/${person.id}")})){
        AsyncImage(
            modifier = Modifier
                .size(40.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop,
            model = if (person.profile_path!=null && person.profile_path.isNotEmpty()
            ) TMDB_IMAGE_PATH+person.profile_path else R.drawable.image_not_available,
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