package com.example.cinemasearcher.ui.components.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemasearcher.ui.theme.CLBTypography
import com.example.cinemasearcher.ui.theme.LocalCLBExtraColors

@Composable
fun CategoriesItem(){
    Card(backgroundColor = LocalCLBExtraColors.current.Soft,
        shape = RoundedCornerShape(8.dp)) {
        Text(
            text = "Comedy",
            Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            style = CLBTypography.body2,
            fontWeight = FontWeight.Medium,
            color = LocalCLBExtraColors.current.WhiteGray
        )
    }
}

@Preview
@Composable
fun CategoriesItemPreview(){
    CategoriesItem()
}