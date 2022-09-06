package com.example.cinemasearcher.presentation.components.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemasearcher.presentation.theme.CLBColors

@Composable
fun UpcomingSelector() {
    Row() {
        Surface(
            shape = CircleShape,
            modifier = Modifier
                .size(8.dp)
                .clickable { },
            color = CLBColors.primary.copy(0.32F)) {}
        Spacer(Modifier.width(8.dp))
        Surface(
            shape = CircleShape,
            modifier = Modifier
                .width(24.dp)
                .height(8.dp)
                .clickable { },
            color = CLBColors.primary) {}
        Spacer(Modifier.width(8.dp))
        Surface(
            shape = CircleShape,
            modifier = Modifier
                .size(8.dp)
                .clickable { },
            color = CLBColors.primary.copy(0.32F)) {}
    }
}

@Preview
@Composable
fun NewSelectorPreview(){
    UpcomingSelector()
}

//TODO Add functional for buttons