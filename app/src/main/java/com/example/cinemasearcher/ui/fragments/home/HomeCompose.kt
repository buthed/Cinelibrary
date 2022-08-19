package com.example.cinemasearcher.ui.fragments.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cinemasearcher.ui.core.AppealDropDownMenu
import com.example.cinemasearcher.ui.core.CustomTextField
import com.example.cinemasearcher.ui.core.SearchField
import com.example.cinemasearcher.ui.theme.LocalCLBExtraColors

@Composable
fun HomeScreen() {
    Column() {
        CustomTextField(input = "123", onValueChange = {}, label = "PlaceHolder")
        AppealDropDownMenu(input = "", onValueChange = {}, label = "Dropdown")
        SearchField(input = "", onValueChange = {}, label = "Dropdown")
    }
}