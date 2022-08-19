package com.example.cinemasearcher.ui.core

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemasearcher.ui.theme.CLBTypography
import com.example.cinemasearcher.ui.theme.LocalCLBExtraColors

@Preview
@Composable
fun ComposableButtonsPreview() {
    Column() {
        ExtraLargeButton("Extra Large",{})
        LargeButton(text = "Large",{})
        MediumButton(text = "Medium",{})
        SmallButton(text = "Small",{})
        ExtraSmallButton(text = "ExtraSmall",{})
    }
}

@Composable
fun ExtraLargeButton(text: String, onClick: () -> Unit){
    RoundedButton(text = text, onClick = onClick, modifier = Modifier.padding(vertical = 14.dp, horizontal = 24.dp))
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