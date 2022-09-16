package com.tematikhonov.cinelibrary.presentation.components.search

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematikhonov.cinelibrary.domain.models.enumeration.SearchCategory
import com.tematikhonov.cinelibrary.presentation.theme.CLBTypography
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors

@Composable
fun SearchCategory(text: SearchCategory, chosenCategory: SearchCategory, onClick: () -> Unit) {
    if (text == chosenCategory) {
        Card(Modifier.defaultMinSize(minWidth = 110.dp).clickable {
                onClick
        },
            backgroundColor = LocalCLBExtraColors.current.Soft,
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(2.dp, LocalCLBExtraColors.current.BlueAccent)
        ) {
            Text(
                text = text.toString(),
                Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                textAlign = TextAlign.Center,
                style = CLBTypography.body2,
                fontWeight = FontWeight.Medium,
                color = LocalCLBExtraColors.current.BlueAccent
            )
        }
    } else {
        Card(Modifier.defaultMinSize(minWidth = 100.dp).clickable(onClick = onClick),
            backgroundColor = LocalCLBExtraColors.current.Soft,
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = text.toString(),
                Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                textAlign = TextAlign.Center,
                style = CLBTypography.body2,
                fontWeight = FontWeight.Medium,
                color = LocalCLBExtraColors.current.WhiteGray
            )
        }
    }

}

@Preview
@Composable
fun CategoriesItemPreview(){
    Column() {
        SearchCategory(SearchCategory.MOVIES,SearchCategory.MOVIES) {}
        SearchCategory(SearchCategory.ACTORS,SearchCategory.ACTORS) {}
    }
}