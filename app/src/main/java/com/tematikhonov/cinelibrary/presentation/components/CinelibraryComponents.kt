package com.tematikhonov.cinelibrary.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematikhonov.cinelibrary.R
import com.tematikhonov.cinelibrary.presentation.theme.CLBTypography
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors

@Preview
@Composable
fun CinelibraryComponentsPreview() {
    Column() {
        ExtraLargeButton("Extra Large",{})
        RoundedButton("Rounded Button",  enabled = true, onClick = {})
        RoundedPlayButton("RoundedPlayButton", onClick = {}, colors = ButtonDefaults.buttonColors())
        Row() {
            ClbSwitch(true,{})
            ClbSwitch(false,{})
        }
    }
}

@Composable
fun ExtraLargeButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier
    .fillMaxWidth()
    .padding(vertical = 10.dp, horizontal = 24.dp), enabled: Boolean = true){
    RoundedButton(text = text, onClick = onClick, modifier = modifier, enabled = enabled)
}

@Composable
fun RoundedButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean,
    onClick: () -> Unit,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        backgroundColor = LocalCLBExtraColors.current.BlueAccent,
    )
){
        Button(
            onClick = onClick,
            shape = RoundedCornerShape(100),
            colors = colors,
            enabled = enabled
        ) {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                modifier = modifier,
                style = CLBTypography.h4,
                color = LocalCLBExtraColors.current.Whiter
            )
        }
}

@Composable
fun RoundedPlayButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    colors: ButtonColors
){
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(100),
        colors = colors
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "",
                Modifier
                    .size(24.dp)
                    .padding(5.dp),
                tint = Color.White)
            Spacer(Modifier.width(8.dp))
            Text(
                text = text,
                style = CLBTypography.h4,

                color = LocalCLBExtraColors.current.Whiter
            )
        }
    }
}

@Composable
fun OutlinedRoundedPlayButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    colors: ButtonColors,
    border: BorderStroke
){
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(100),
        colors = colors,
        border = border
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = text,
                style = CLBTypography.h4,
                color = LocalCLBExtraColors.current.BlueAccent
            )
        }
    }
}

@Composable
fun ClbSwitch(checked: Boolean,onCheckedChange: ((Boolean) -> Unit)) {
    Switch(checked, onCheckedChange,
        colors = SwitchDefaults.colors(
            checkedThumbColor = LocalCLBExtraColors.current.Whiter,
            checkedTrackColor = LocalCLBExtraColors.current.BlueAccent,
            uncheckedTrackColor = LocalCLBExtraColors.current.Gray,
            disabledCheckedTrackColor = LocalCLBExtraColors.current.Gray,
            disabledUncheckedThumbColor = LocalCLBExtraColors.current.DarkGray,
        ))

}

//TODO Add ...More to story line.
//TODO Fix first row on scroll
//TODO Add Gallery