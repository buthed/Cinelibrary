package com.tematikhonov.cinelibrary.presentation.core

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tematikhonov.cinelibrary.R
import com.tematikhonov.cinelibrary.presentation.theme.LocalCLBExtraColors

@Preview
@Composable
fun ComposablePlaceholdersPreview() {
    Column() {
        CustomTextField(input = "123", onValueChange = {}, label = "PlaceHolder", value = "")
        AppealDropDownMenu(input = "", onValueChange = {}, label = "Dropdown")
        SearchField(input = "", onValueChange = {}, label = "Dropdown", value = "")
    }
}

@Composable
fun SearchField(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(35.dp),
    input: String,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
){
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(100)
    ){
        Row(
            Modifier
                .background(LocalCLBExtraColors.current.Soft)
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = "", tint = Color.Gray)
            CustomTextField(
                modifier = Modifier
                    .height(50.dp),
                input = input,
                value = value,
                onValueChange = onValueChange,
                label = label
            )
            Icon(painter = painterResource(id = R.drawable.ic_filter), contentDescription = "", tint = Color.White)
        }
    }
}

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(50.dp),
    input: String,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
) {

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(100),
        textStyle = TextStyle(color = LocalCLBExtraColors.current.Gray,),
        placeholder = { Text(label) },
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = LocalCLBExtraColors.current.Gray,
            disabledTextColor = LocalCLBExtraColors.current.Gray,
            backgroundColor = LocalCLBExtraColors.current.Soft,
            placeholderColor = LocalCLBExtraColors.current.Gray,
            disabledPlaceholderColor = LocalCLBExtraColors.current.Gray,
            cursorColor = LocalCLBExtraColors.current.Gray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            leadingIconColor = LocalCLBExtraColors.current.Gray,
            trailingIconColor = LocalCLBExtraColors.current.Gray,
            focusedLabelColor = LocalCLBExtraColors.current.Gray,
            unfocusedLabelColor = LocalCLBExtraColors.current.Gray,
        ),
    )
}

@Composable
fun LoginTextField(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(60.dp),
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
) {

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(100),
        textStyle = TextStyle(fontStyle = FontStyle.Normal, color = LocalCLBExtraColors.current.Gray),
        label = { Text(text = label, color =  LocalCLBExtraColors.current.WhiteGray) },
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            textColor = LocalCLBExtraColors.current.Gray,
            disabledTextColor = LocalCLBExtraColors.current.Gray,
            backgroundColor = LocalCLBExtraColors.current.Dark,
            placeholderColor = LocalCLBExtraColors.current.Gray,
            disabledPlaceholderColor = LocalCLBExtraColors.current.Gray,
            cursorColor = LocalCLBExtraColors.current.Gray,
            focusedIndicatorColor = LocalCLBExtraColors.current.Soft,
            unfocusedIndicatorColor = LocalCLBExtraColors.current.Soft,
            focusedLabelColor = LocalCLBExtraColors.current.Whiter,
            unfocusedLabelColor = LocalCLBExtraColors.current.Gray,
        ),
    )
}

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(60.dp),
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    passVisibility: () -> Unit,
    visualTransformation: VisualTransformation = PasswordVisualTransformation()
) {

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(100),
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        textStyle = TextStyle(fontStyle = FontStyle.Normal, color = LocalCLBExtraColors.current.Gray),
        label = { Text(text = label, color =  LocalCLBExtraColors.current.WhiteGray) },
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = LocalCLBExtraColors.current.Gray,
            disabledTextColor = LocalCLBExtraColors.current.Gray,
            backgroundColor = LocalCLBExtraColors.current.Dark,
            placeholderColor = LocalCLBExtraColors.current.Gray,
            disabledPlaceholderColor = LocalCLBExtraColors.current.Gray,
            cursorColor = LocalCLBExtraColors.current.Gray,
            focusedIndicatorColor = LocalCLBExtraColors.current.Soft,
            unfocusedIndicatorColor = LocalCLBExtraColors.current.Soft,
            trailingIconColor = LocalCLBExtraColors.current.Gray,
            focusedLabelColor = LocalCLBExtraColors.current.Whiter,
            unfocusedLabelColor = LocalCLBExtraColors.current.Gray,
        ),
        trailingIcon = { Icon(painter = painterResource(id = R.drawable.ic_eye_off),
            contentDescription = "",
            Modifier.clickable(onClick = passVisibility)
        ) }
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
                focusedLabelColor = LocalCLBExtraColors.current.WhiteGray,
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

//TODO Add Icon for searchfield