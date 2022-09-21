package com.tematikhonov.cinelibrary.presentation.ui.person

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.tematikhonov.cinelibrary.R
import com.tematikhonov.cinelibrary.domain.models.ApiConstants.TMDB_IMAGE_PATH
import com.tematikhonov.cinelibrary.domain.models.entites.Person
import com.tematikhonov.cinelibrary.presentation.components.ContentTitle
import com.tematikhonov.cinelibrary.presentation.components.person.PersonDetailsBackground
import com.tematikhonov.cinelibrary.presentation.theme.CLBTypography
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors

@Composable
fun PersonScreen(personId: String, navController: NavHostController) {
    var fullBiographyVisibility by remember { mutableStateOf(false) }
    val viewModel = hiltViewModel<PersonViewModel>()
    viewModel.init(personId.toInt())
    val person = viewModel.person.observeAsState().value

    Surface(Modifier.fillMaxSize()) {
        if (person!=null) {
            PersonDetailsBackground(person)
            Column(Modifier.padding(horizontal = 24.dp)) {
                Box(contentAlignment = Alignment.TopCenter) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_left),
                            contentDescription = "",
                            Modifier.clickable { navController.popBackStack() },
                            tint = Color.White,
                        )
                        Text(text = person.name, style = CLBTypography.h4)
                        Icon(
                            painter = painterResource(id = R.drawable.ic_heart),
                            contentDescription = "",
                            tint = Color.Red
                        )
                    }
                }
                Column(
                    Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    Spacer(Modifier.height(24.dp))
                    AsyncImage(model = if (person.profile_path!=null && person.profile_path.isNotEmpty()
                        ) TMDB_IMAGE_PATH+person.profile_path else R.drawable.image_not_available,
                        contentDescription = person.name,
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 70.dp),
                        contentScale = ContentScale.FillWidth,
                        alignment = Alignment.TopCenter
                    )
                    ContentTitle(text = stringResource(id = R.string.person_personal_info))
                    Column() {
                        PersonalInfoRow(stringResource(id = R.string.person_known_for),person.known_for_department)
                        PersonalInfoRow(stringResource(id = R.string.person_known_credits),person.popularity.toString())
                        PersonalInfoRow(stringResource(id = R.string.person_gender),person.gender.toString())
                        PersonalInfoRow(stringResource(id = R.string.person_birthday),
                            person.birthday ?: stringResource(id = R.string.no_data))
                        PersonalInfoRow(stringResource(id = R.string.person_place_of_birth),
                            person.place_of_birth ?: stringResource(id = R.string.no_data))
                    }
                    if (person.biography.isNotEmpty()) {
                        ContentTitle(text = stringResource(id = R.string.person_biography))
                        if (fullBiographyVisibility) Text(text = person.biography,
                            Modifier.clickable { fullBiographyVisibility = !fullBiographyVisibility })
                        else {
//                        buildAnnotatedString{
//                            append(text = person.biography)
//                            append(text = "See all")
//                            toAnnotatedString()
//                        }
                            Text(text = person.biography,
                                Modifier.clickable { fullBiographyVisibility = !fullBiographyVisibility },
                                maxLines = 5)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PersonalInfoRow(title:String, desc: String) {
    Row(horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,) {
        Text(text = title, style = CLBTypography.h5, color = Color.White)
        Text(text = desc, style = CLBTypography.body1, color = LocalCLBExtraColors.current.Gray)
    }
}

@Preview
@Composable
fun PersonScreenPreview() {
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
        profile_path = "/5XBzD5WuTyVQZeS4VI25z2moMeY.jpg"

    )
    PersonScreen(personId = "819",navController = navController)
}
