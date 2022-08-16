package com.example.cinemasearcher.presentation.core

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinemasearcher.ui.theme.LocalCLBExtraColors

@Preview
@Composable
fun ComposablePlaceholdersPreview() {
    Column() {
        CustomTextField(input = "", onValueChange = {}, label = "PlaceHolder")
        AppealDropDownMenu(input = "", onValueChange = {}, label = "Dropdown")
    }
}

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(50.dp),
    input: String,
    onValueChange: (String) -> Unit,
    label: String,
) {
    var inputs by remember { mutableStateOf(input) }

    TextField(
        modifier = modifier,
        value = inputs,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(100),
        label = { Text(label) },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = LocalCLBExtraColors.current.Soft,
            focusedLabelColor = LocalCLBExtraColors.current.WhiteGrey,
            unfocusedLabelColor = LocalCLBExtraColors.current.Gray,
        ),
    )
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AppealDropDownMenu(modifier: Modifier = Modifier
    .fillMaxWidth()
    .height(50.dp),
                       input: String,
                       onValueChange: (String) -> Unit,
                       label: String
) {
    val options  = listOf(
        "1",
        "2",
        "3"
    )

    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(label) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            readOnly = true,
            value = selectedOptionText,
            onValueChange = { },
            shape = RoundedCornerShape(100),
            leadingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = LocalCLBExtraColors.current.Soft,
                focusedLabelColor = LocalCLBExtraColors.current.WhiteGrey,
                unfocusedLabelColor = LocalCLBExtraColors.current.Gray
            ),
            textStyle = TextStyle(fontSize = 16.sp )
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    }
                ) {
                    Text(text = selectionOption)
                }
            }
        }
    }
}