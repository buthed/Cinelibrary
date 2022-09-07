package com.tematikhonov.cinelibrary.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematikhonov.cinelibrary.R
import com.tematikhonov.cinelibrary.presentation.theme.CLBTypography
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors

@Preview
@Composable
fun ComposableButtonsPreview() {
    Column() {
        ExtraLargeButton("Extra Large",{})
        LargeButton(text = "Large",{})
        MediumButton(text = "Medium",{})
        SmallButton(text = "Small",{})
        ExtraSmallButton(text = "ExtraSmall",{})
        ExtraLargePlayButton("Play",{})
    }
}

@Composable
fun ExtraLargePlayButton(text: String, onClick: () -> Unit){
    RoundedPlayButton(text = text, onClick = onClick, modifier = Modifier.padding(vertical = 4.dp, horizontal = 24.dp),
    colors = ButtonDefaults.buttonColors(backgroundColor =  LocalCLBExtraColors.current.Orange))
}


@Composable
fun ExtraLargeButton(text: String, onClick: () -> Unit){
    RoundedButton(text = text, onClick = onClick, modifier = Modifier.padding(vertical = 4.dp, horizontal = 24.dp))
}

@Composable
fun LargeButton(text: String, onClick: () -> Unit){
    RoundedButton(text = text, onClick = onClick, modifier = Modifier.padding(vertical = 12.dp, horizontal = 24.dp))
}

@Composable
fun MediumButton(text: String, onClick: () -> Unit){
    RoundedButton(text = text, onClick = onClick, modifier = Modifier.padding(vertical = 8.dp, horizontal = 24.dp))
}

@Composable
fun SmallButton(text: String, onClick: () -> Unit){
    RoundedButton(text = text, onClick = onClick, modifier = Modifier.padding(vertical = 4.dp, horizontal = 24.dp))
}

@Composable
fun ExtraSmallButton(text: String, onClick: () -> Unit){
    RoundedButton(text = text, onClick = onClick, modifier = Modifier.padding(horizontal = 24.dp))
}

@Composable
fun RoundedButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
){
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(100),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = LocalCLBExtraColors.current.BlueAccent,
            )
        ) {
            Text(
                text = text,
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

//TODO Add ...More to story line.
//TODO Fix first row on scroll
//TODO Add Gallery