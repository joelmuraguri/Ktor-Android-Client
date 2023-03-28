package com.joel.ktor_android_client_calls

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.joel.ktor_android_client_calls.grouped_response.navigation.GroupedResponseNavigation
import com.joel.ktor_android_client_calls.grouped_response.presentation.views.CoinsListScreen
import com.joel.ktor_android_client_calls.ui.theme.KtorAndroidClientCallsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KtorAndroidClientCallsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GroupedResponseNavigation()
                }
            }
        }
    }
}

