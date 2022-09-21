package com.tematikhonov.cinelibrary.presentation.components.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematikhonov.cinelibrary.R
import com.tematikhonov.cinelibrary.presentation.components.OutlinedRoundedPlayButton
import com.tematikhonov.cinelibrary.presentation.components.RoundedButton
import com.tematikhonov.cinelibrary.presentation.theme.CLBTypography
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors

@Composable
fun LogOutAlert(closeAction: () -> Unit, logout: () -> Unit) {
    Box(
        Modifier
            .fillMaxSize()
            .background(LocalCLBExtraColors.current.Dark.copy(0.85f))
            .blur(40.dp)
            .clickable(onClick = closeAction),
        contentAlignment = Alignment.Center
    ){
        Card( Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
            .clickable { },
            shape = RoundedCornerShape(16.dp),
            backgroundColor = LocalCLBExtraColors.current.Soft
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(painter = painterResource(id = R.drawable.ic_question_colored),
                    contentDescription = "",
                    Modifier.size(125.dp).padding(top = 30.dp))
                Text(text = stringResource(id = R.string.profile_log_out_alert_title),
                    style = CLBTypography.h3, color = LocalCLBExtraColors.current.Whiter)
                Row(Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedRoundedPlayButton(text = stringResource(id = R.string.profile_log_out),
                        onClick = logout,
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = LocalCLBExtraColors.current.Dark,
                            contentColor = LocalCLBExtraColors.current.BlueAccent),
                        border = BorderStroke(1.dp, LocalCLBExtraColors.current.BlueAccent))

                    RoundedButton(text = stringResource(id = R.string.profile_log_out_alert_cancel),
                        onClick = closeAction,
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = LocalCLBExtraColors.current.Dark,
                            contentColor = LocalCLBExtraColors.current.BlueAccent),
                        enabled = true)
                }
                Spacer(Modifier.height(30.dp))
            }
        }
    }
}

@Preview
@Composable
fun LogOutAlertPreview() {
    LogOutAlert({},{})
}