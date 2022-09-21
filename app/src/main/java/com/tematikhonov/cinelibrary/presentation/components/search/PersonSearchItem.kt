package com.tematikhonov.cinelibrary.presentation.components.search

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.tematikhonov.cinelibrary.R
import com.tematikhonov.cinelibrary.domain.models.ApiConstants
import com.tematikhonov.cinelibrary.domain.models.ApiConstants.TMDB_IMAGE_PATH
import com.tematikhonov.cinelibrary.domain.models.entites.*
import com.tematikhonov.cinelibrary.presentation.components.movieDetails.InfoTabIcon
import com.tematikhonov.cinelibrary.presentation.components.movieDetails.InfoTabText
import com.tematikhonov.cinelibrary.presentation.theme.CLBTypography
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors

@Composable
fun PersonSearchItem(navController: NavHostController, person: Person) {
    Row(
        Modifier
            .fillMaxWidth()
            .clickable {
                Log.d("checkDataM", "ID: ${person.id} title: ${person.name}")
                navController.navigate("Person/${person.id}")
            }) {
        Box(
            Modifier
                .width(70.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
            Column() {
                AsyncImage(model = if (person.profile_path!=null && person.profile_path.isNotEmpty()
                ) TMDB_IMAGE_PATH+person.profile_path else R.drawable.image_not_available,
                    contentDescription = person.name)
            }
        }
        Spacer(Modifier.width(16.dp))
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(text = person.name,
                style = CLBTypography.h4,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis)
            Text(text = person.known_for_department,
                style = CLBTypography.h4,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis)
            Text(text = if (person.birthday!=null) person.birthday.toString() else "",
                style = CLBTypography.h4,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis)
        }
    }
}

@Composable
fun PersonSearchSmallItem(navController: NavHostController, person: Person) {
    Column(
        Modifier
            .fillMaxWidth()
            .clickable {
                Log.d("checkDataM", "ID: ${person.id} title: ${person.name}")
                navController.navigate("Person/${person.id}")
            },
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .size(100.dp)
                .clip(CircleShape)
        ) {
            Column() {

                AsyncImage(model = if (person.profile_path!=null && person.profile_path.isNotEmpty()
                ) TMDB_IMAGE_PATH+person.profile_path else R.drawable.image_not_available,
                    contentDescription = person.name,
                    contentScale = ContentScale.FillWidth)
            }
        }
        Text(text = person.name,
            style = CLBTypography.h4,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis)
    }
}

@Preview
@Composable
fun SearchItemPreview() {
    val navController = rememberNavController()
    val person = Person(
        adult = false,
        also_known_as = listOf(" Edward Harrison ",
            "Ed Norton",),
        biography = "Edward Harrison Norton (born August 18, 1969) is an American actor and filmmaker. He has received numerous awards and nominations, including a Golden Globe Award and three Academy Award nominations.\n\nBorn in Boston, Massachusetts and raised in Columbia, Maryland, Norton was drawn to theatrical productions at local venues as a child. After graduating from Yale College in 1991, he worked for a few months in Japan before moving to New York City to pursue an acting career. He gained immediate recognition and critical acclaim for his debut in Primal Fear (1996), which earned him a Golden Globe for Best Supporting Actor and an Academy Award nomination in the same category. His role as a reformed neo-Nazi in American History X (1998) earned him an Academy Award nomination for Best Actor. He also starred in the film Fight Club (1999), which garnered a cult following.\n\nNorton emerged as a filmmaker in the 2000s. He established the production company Class 5 Films in 2003, and was director or producer of the films Keeping the Faith (2000), Down in the Valley (2005), and The Painted Veil (2006). He continued to receive critical acclaim for his acting roles in films such as The Score (2001), 25th Hour (2002), The Illusionist (2006), Moonrise Kingdom (2012), and The Grand Budapest Hotel (2014). His biggest commercial successes have been Red Dragon (2002), Kingdom of Heaven (2005), The Incredible Hulk (2008), and The Bourne Legacy (2012). For his role in the black comedy Birdman (2014), Norton earned another Academy Award nomination for Best Supporting Actor.",
        birthday = "1969-08-18",
        deathday = null,
        gender = 2,
        homepage = null,
        id = 819,
        imdb_id = "nm0001570",
        known_for_department = "Acting",
        name = "Edward Norton",
        place_of_birth = "Boston, Massachusetts, USA",
        popularity = 20.698,
        profile_path = "/5XBzD5WuTyVQZeS4VI25z2moMeY.jpg")
    PersonSearchItem(navController, person)
}

@Preview
@Composable
fun SearchSmallItemPreview() {
    val navController = rememberNavController()
    val person = Person(
        adult = false,
        also_known_as = listOf(" Edward Harrison ",
            "Ed Norton",),
        biography = "Edward Harrison Norton (born August 18, 1969) is an American actor and filmmaker. He has received numerous awards and nominations, including a Golden Globe Award and three Academy Award nominations.\n\nBorn in Boston, Massachusetts and raised in Columbia, Maryland, Norton was drawn to theatrical productions at local venues as a child. After graduating from Yale College in 1991, he worked for a few months in Japan before moving to New York City to pursue an acting career. He gained immediate recognition and critical acclaim for his debut in Primal Fear (1996), which earned him a Golden Globe for Best Supporting Actor and an Academy Award nomination in the same category. His role as a reformed neo-Nazi in American History X (1998) earned him an Academy Award nomination for Best Actor. He also starred in the film Fight Club (1999), which garnered a cult following.\n\nNorton emerged as a filmmaker in the 2000s. He established the production company Class 5 Films in 2003, and was director or producer of the films Keeping the Faith (2000), Down in the Valley (2005), and The Painted Veil (2006). He continued to receive critical acclaim for his acting roles in films such as The Score (2001), 25th Hour (2002), The Illusionist (2006), Moonrise Kingdom (2012), and The Grand Budapest Hotel (2014). His biggest commercial successes have been Red Dragon (2002), Kingdom of Heaven (2005), The Incredible Hulk (2008), and The Bourne Legacy (2012). For his role in the black comedy Birdman (2014), Norton earned another Academy Award nomination for Best Supporting Actor.",
        birthday = "1969-08-18",
        deathday = null,
        gender = 2,
        homepage = null,
        id = 819,
        imdb_id = "nm0001570",
        known_for_department = "Acting",
        name = "Edward Norton",
        place_of_birth = "Boston, Massachusetts, USA",
        popularity = 20.698,
        profile_path = "/5XBzD5WuTyVQZeS4VI25z2moMeY.jpg")
    PersonSearchSmallItem(navController, person)
}
//TODO add gender