package com.tematikhonov.cinelibrary.presentation.ui.profile

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
import com.tematikhonov.cinelibrary.presentation.components.ClbSwitch
import com.tematikhonov.cinelibrary.presentation.components.OutlinedRoundedPlayButton
import com.tematikhonov.cinelibrary.presentation.components.profile.LogOutAlert
import com.tematikhonov.cinelibrary.presentation.theme.CLBTypography
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors
import com.tematikhonov.cinelibrary.presentation.ui.auth.AuthViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ProfileScreen(navController: NavHostController) {
    var logoutAlertVisibility by remember { mutableStateOf(false) }
    val viewModel = hiltViewModel<ProfileViewModel>()
    val checkedState = remember { mutableStateOf(viewModel.getNotificationBoolean()) }
    val auth = Firebase.auth
    val viewModelAuth = hiltViewModel<AuthViewModel>()
    Column(
        Modifier
            .fillMaxSize()
            .background(LocalCLBExtraColors.current.Dark)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Card(border = BorderStroke(width = 1.dp, LocalCLBExtraColors.current.Soft),
            shape = RoundedCornerShape(16.dp),
            backgroundColor = LocalCLBExtraColors.current.Dark
        ) {
            Text(text = if (auth.currentUser?.isAnonymous == false) auth.currentUser?.email.toString() else stringResource(id = R.string.profile_anonymous),
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                style = CLBTypography.h5,
                color = LocalCLBExtraColors.current.Whiter,
                textAlign = TextAlign.Center)
        }

        Card(border = BorderStroke(width = 1.dp, LocalCLBExtraColors.current.Soft),
            shape = RoundedCornerShape(16.dp),
            backgroundColor = LocalCLBExtraColors.current.Dark
        ) {
            Column() {
                Text(text = stringResource(id = R.string.profile_general),
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp),
                    textAlign = TextAlign.Start,
                    color = LocalCLBExtraColors.current.Whiter,
                    style = CLBTypography.h3)
                ItemSwitchRow("Notification",
                    painterResource(id = R.drawable.ic_notification),
                    {},
                    checked = checkedState.value,
                    onCheckedChange = {
                        checkedState.value = it
                        viewModel.setNotificationPref(it)
                    }
                )
                ProfileDivider()
                ItemRow("Language", painterResource(id = R.drawable.ic_globe)) {
                    navController.navigate(NavItem.Language.navRoute)
                }
                ProfileDivider()
                ItemRow("Clear Cache", painterResource(id = R.drawable.ic_trash_bin)) {
                    viewModel.clearCache()
                }
            }
        }

        Card(border = BorderStroke(width = 1.dp, LocalCLBExtraColors.current.Soft),
            shape = RoundedCornerShape(16.dp),
            backgroundColor = LocalCLBExtraColors.current.Dark
        ) {
            Column() {
                Text(text = stringResource(id = R.string.profile_more),
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp),
                    textAlign = TextAlign.Start,
                    color = LocalCLBExtraColors.current.Whiter,
                    style = CLBTypography.h3)
                ItemRow("Legal and Policies", painterResource(id = R.drawable.ic_shield)) {
                    navController.navigate(NavItem.Policies.navRoute)
                }
                ProfileDivider()
                ItemRow("Help & Feedback", painterResource(id = R.drawable.ic_question)) {
                    navController.navigate(NavItem.Help.navRoute)
                }
                ProfileDivider()
                ItemRow("About Us", painterResource(id = R.drawable.ic_alert)) {
                    navController.navigate(NavItem.About.navRoute)
                }
            }
        }

        OutlinedRoundedPlayButton(text = stringResource(id = R.string.profile_log_out),
            onClick = { logoutAlertVisibility = true },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 24.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = LocalCLBExtraColors.current.Dark,
                contentColor = LocalCLBExtraColors.current.BlueAccent),
            border = BorderStroke(1.dp, LocalCLBExtraColors.current.BlueAccent)
        )
    }
    AnimatedVisibility(visible = logoutAlertVisibility,
        enter = fadeIn() + scaleIn(),
        exit = fadeOut() + scaleOut()
    ) {
        LogOutAlert(closeAction = { logoutAlertVisibility = false },
        logout = {
            viewModelAuth.signOut()
            navController.navigate(NavItem.Welcome.navRoute)
        }) 
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

@Composable
fun ItemSwitchRow(text:String, painter: Painter, onClick: () -> Unit = {},checked: Boolean, onCheckedChange: ((Boolean) -> Unit)){
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
        ClbSwitch(checked, onCheckedChange)
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

