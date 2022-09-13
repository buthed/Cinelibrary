package com.tematikhonov.cinelibrary.presentation.ui.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tematikhonov.cinelibrary.R
import com.tematikhonov.cinelibrary.presentation.NavItem
import com.tematikhonov.cinelibrary.presentation.components.OutlinedRoundedPlayButton
import com.tematikhonov.cinelibrary.presentation.components.RoundedPlayButton
import com.tematikhonov.cinelibrary.presentation.theme.CLBTypography
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors
import com.tematikhonov.cinelibrary.presentation.ui.auth.AuthViewModel

@Composable
fun ProfileScreen(navController: NavHostController) {
    val auth = Firebase.auth
    val viewModel = hiltViewModel<AuthViewModel>()
    Box(
        Modifier
            .fillMaxSize()
            .background(LocalCLBExtraColors.current.Dark)
    ){
        Column(
            Modifier.fillMaxSize().padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Card(
                Modifier
                    .fillMaxWidth()
                    .border(width = 1.dp, LocalCLBExtraColors.current.Soft),
                shape = RoundedCornerShape(8.dp),
                backgroundColor = LocalCLBExtraColors.current.Dark
            ) {
                Text(text = auth.currentUser?.email.toString(),
                    Modifier.fillMaxWidth().padding(vertical = 8.dp),
                    style = CLBTypography.h5,
                    color = LocalCLBExtraColors.current.Whiter)
            }

            Card(
                Modifier
                    .fillMaxWidth()
                    .border(width = 1.dp, LocalCLBExtraColors.current.Soft),
                shape = RoundedCornerShape(8.dp),
                backgroundColor = LocalCLBExtraColors.current.Dark
            ) {
                Column() {
                    Text(text = stringResource(id = R.string.profile_general),
                        Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start,
                        color = LocalCLBExtraColors.current.Whiter,
                        style = CLBTypography.h3)
                    Spacer(Modifier.height(8.dp))
                    ItemRow("Notification", painterResource(id = R.drawable.ic_notification),{})
                    ProfileDivider()
                    ItemRow("Language", painterResource(id = R.drawable.ic_globe),{})
                    ProfileDivider()
                    ItemRow("Country", painterResource(id = R.drawable.ic_flag),{})
                    ProfileDivider()
                    ItemRow("Clear Cache", painterResource(id = R.drawable.ic_trash_bin),{})
                }
            }

            Card(
                Modifier
                    .fillMaxWidth()
                    .border(width = 1.dp, LocalCLBExtraColors.current.Soft),
                shape = RoundedCornerShape(8.dp),
                backgroundColor = LocalCLBExtraColors.current.Dark
            ) {
                Column() {
                    Text(text = stringResource(id = R.string.profile_more),
                        Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start,
                        color = LocalCLBExtraColors.current.Whiter,
                        style = CLBTypography.h3)
                    Spacer(Modifier.height(8.dp))
                    ItemRow("Legal and Policies", painterResource(id = R.drawable.ic_shield),{})
                    ProfileDivider()
                    ItemRow("Help & Feedback", painterResource(id = R.drawable.ic_question),{})
                    ProfileDivider()
                    ItemRow("About Us", painterResource(id = R.drawable.ic_alert),{})
                }
            }

            OutlinedRoundedPlayButton(text = stringResource(id = R.string.profile_log_out),
                onClick = {
                    viewModel.signOut()
                    navController.navigate(NavItem.Welcome.navRoute)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 24.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = LocalCLBExtraColors.current.Dark,
                    contentColor = LocalCLBExtraColors.current.BlueAccent),
                border = BorderStroke(1.dp, LocalCLBExtraColors.current.BlueAccent)
            )
        }
    }
}

@Composable
fun ItemRow(text:String, painter: Painter, onClick: () -> Unit = {}){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = onClick),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Box(
                Modifier
                    .clip(CircleShape)
                    .background(LocalCLBExtraColors.current.Soft)
                    .size(30.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(painter = painter,
                    contentDescription = "",
                    Modifier.size(24.dp),
                    tint = LocalCLBExtraColors.current.Gray
                )
            }
            Spacer(Modifier.width(20.dp))
            Text(text = text,
                style = CLBTypography.h5,
                color = LocalCLBExtraColors.current.Whiter)
        }
        Icon(painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = "",
            tint = LocalCLBExtraColors.current.BlueAccent)
    }
}

@Preview
@Composable
fun ItemRowPreview() {
    ItemRow("Notification", painterResource(id = R.drawable.ic_notification),{})
}

@Composable
fun ProfileDivider() {
    Divider(color = LocalCLBExtraColors.current.Soft,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        thickness = 1.dp)
}


@Preview
@Composable
fun ProfileScreenPreview() {
    val navController = rememberNavController()
    ProfileScreen(navController)
}