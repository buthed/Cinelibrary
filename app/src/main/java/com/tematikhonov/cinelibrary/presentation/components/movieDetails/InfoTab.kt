package com.tematikhonov.cinelibrary.presentation.components.movieDetails

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematikhonov.cinelibrary.R
import com.tematikhonov.cinelibrary.domain.models.entites.*
import com.tematikhonov.cinelibrary.presentation.theme.CLBTypography
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors

@Composable
fun InfoTab(movie: Movie){
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.height(8.dp))
        Row(Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {
            InfoTabIcon(painterResource(id = R.drawable.ic_calendar), "")
            InfoTabText(text = movie.release_date.dropLast(6))
            InfoTabSeparator()
            InfoTabIcon(painterResource(id = R.drawable.ic_clock), "")
            InfoTabText(text = movie.runtime.toString() +" " + stringResource(id = R.string.movie_minutes))
            InfoTabSeparator()
            InfoTabIcon(painterResource(id = R.drawable.ic_film), "")
            InfoTabText(text = movie.genres[0].name)
        }
        Card(
            Modifier.padding(top = 8.dp),
            backgroundColor = LocalCLBExtraColors.current.Soft,
            contentColor = LocalCLBExtraColors.current.Soft,
            shape = RoundedCornerShape(10.dp)
        ) {
            Row(
                Modifier
                    .width(55.dp)
                    .height(24.dp),
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
                    text = movie.vote_average.toString().take(3),
                    textAlign = TextAlign.End,
                    style = CLBTypography.body2,
                    color = LocalCLBExtraColors.current.Orange,
                )
            }
        }
    }
}

@Composable
fun InfoTabIcon(painter: Painter,contentDescription: String){
    Icon(painter = painter,
        contentDescription = contentDescription,
        Modifier
            .size(16.dp)
            .padding(end = 4.dp),
        tint = LocalCLBExtraColors.current.Gray,
    )
}

@Composable
fun InfoTabText(text: String){
    Text(text = text, style = CLBTypography.subtitle1, color = LocalCLBExtraColors.current.Gray, )
}

@Composable
fun InfoTabSeparator(){
    Divider(color = LocalCLBExtraColors.current.Gray,
        modifier = Modifier
            .height(16.dp)
            .padding(horizontal = 12.dp)
            .width(1.dp))
}

@Preview
@Composable
fun InfoTabPreview(){
    val item = Movie(
        adult=false,
        backdrop_path="/jsoz1HlxczSuTx0mDl2h0lxy36l.jpg",
        belongs_to_collection = "1",
        budget = 111,
        genres = listOf(Genre(1,"Action"),Genre(2,"Drama")),
        homepage = "1",
        id=616037,
        imdb_id = "550",
        original_language="en",
        original_title="Thor: Love and Thunder, overview=After his retirement is interrupted by Gorr the God Butcher, a galactic killer who seeks the extinction of the gods, Thor Odinson enlists the help of King Valkyrie, Korg, and ex-girlfriend Jane Foster, who now inexplicably wields Mjolnir as the Relatively Mighty Girl Thor. Together they embark upon a harrowing cosmic adventure to uncover the mystery of the God Butcher’s vengeance and stop him before it’s too late.",
        overview = "",
        popularity=7172.102,
        poster_path="/pIkRyD18kl4FhoCNQuWxWu5cBLM.jpg",
        production_companies = listOf<ProductionCompany>(),
        production_countries = listOf<ProductionCountry>(),
        release_date= "2022-07-06",
        revenue = 1,
        runtime = 130,
        spoken_languages = listOf(),
        status = "1",
        tagline = "",
        title="Thor: Love and Thunder",
        video=false,
        vote_average=6.8,
        vote_count=2034)
    InfoTab(item)
}

//TODO contentDescriptions