package com.example.cinemasearcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.cinemasearcher.ui.components.MainScreen
import com.example.cinemasearcher.ui.theme.CLBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CLBTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun AppScreen(text: String) = Surface(modifier = Modifier.fillMaxSize()) {
    Text(text = text, fontSize = 32.sp)
}
