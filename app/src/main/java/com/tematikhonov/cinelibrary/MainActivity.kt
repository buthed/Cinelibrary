package com.tematikhonov.cinelibrary

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.tematikhonov.cinelibrary.domain.models.Constants.PREF_NOTIFICATION
import com.tematikhonov.cinelibrary.domain.models.Constants.USER_PREFERENCES
import com.tematikhonov.cinelibrary.navigation.NavHost
import com.tematikhonov.cinelibrary.presentation.theme.CLBTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var preferences: SharedPreferences
    private val preferencesListner = SharedPreferences.OnSharedPreferenceChangeListener {
            preferences, s ->  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferences = getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE)
        preferences.registerOnSharedPreferenceChangeListener(preferencesListner)
        preferences.getBoolean(PREF_NOTIFICATION, false)
        setContent {
            val navController = rememberNavController()
            CLBTheme {
                NavHost(navController)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        preferences.unregisterOnSharedPreferenceChangeListener(preferencesListner)
    }
}

@Composable
fun AppScreen(text: String) = Surface(modifier = Modifier.fillMaxSize()) {
    Text(text = text, fontSize = 32.sp)
}
