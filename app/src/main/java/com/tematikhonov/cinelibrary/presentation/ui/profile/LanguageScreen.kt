package com.tematikhonov.cinelibrary.presentation.ui.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tematikhonov.cinelibrary.R
import com.tematikhonov.cinelibrary.domain.models.entites.Language
import com.tematikhonov.cinelibrary.presentation.theme.CLBTypography
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors

@Composable
fun LanguageScreen(navController: NavController) {
    val viewModel = hiltViewModel<ProfileViewModel>()
    val languagesList = viewModel.languages.observeAsState().value

    Column(
        Modifier
            .fillMaxSize()
            .background(LocalCLBExtraColors.current.Dark),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_left),
                contentDescription = "",
                Modifier.clickable(onClick = { navController.popBackStack() }),
                tint = Color.White,
            )
            Text(text = stringResource(id = R.string.profile_language), style = CLBTypography.h4)
            Icon(
                painter = painterResource(id = R.drawable.ic_share),
                contentDescription = "",
                tint = Color.Transparent,
            )
        }

        Card(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            backgroundColor = LocalCLBExtraColors.current.Dark,
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, LocalCLBExtraColors.current.Soft)
        ) {
            Column() {
                Text(text = stringResource(id = R.string.profile_language_suggested),
                    Modifier.padding(start = 16.dp, top = 20.dp),
                    style = CLBTypography.body1, color = LocalCLBExtraColors.current.DarkGray)
                LazyColumn(Modifier.padding(20.dp)) {
                    items(listOf(
                        Language("English", "en", "English"),
                        Language("Russian","ru","Pусский")
                    )) { item ->
                        LanguageRow(if(item.name.isNotEmpty()) item.english_name +" (${item.name})" else item.english_name, false)
                        LanguageDivider()
                    }
                }
            }
        }

        Card(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            backgroundColor = LocalCLBExtraColors.current.Dark,
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, LocalCLBExtraColors.current.Soft)
        ) {
            Column() {
                Text(text = stringResource(id = R.string.profile_language_others),
                    Modifier.padding(start = 16.dp, top = 20.dp),
                    style = CLBTypography.body1, color = LocalCLBExtraColors.current.DarkGray)
                LazyColumn(Modifier.padding(20.dp)){
                    languagesList?.let {
                        items(it) { item ->
                            LanguageRow(if(item.name.isNotEmpty()) item.english_name +" (${item.name})" else item.english_name, false)
                            LanguageDivider()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LanguageRow(text: String, selected: Boolean) {
    Row(Modifier.padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = text, style = CLBTypography.h4)
        Icon(painter = painterResource(id = R.drawable.ic_checkmark),
            contentDescription = "",
            tint = if (selected) LocalCLBExtraColors.current.BlueAccent else Color.Transparent)
    }
}

@Composable
fun LanguageDivider() {
    Divider(color = LocalCLBExtraColors.current.Soft,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        thickness = 1.dp)
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF1F1D2B
)
@Composable
fun LanguageScreenPreview() {
    val navController = rememberNavController()
    LanguageScreen(navController)
}