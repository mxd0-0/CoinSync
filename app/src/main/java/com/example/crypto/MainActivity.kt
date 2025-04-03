package com.example.crypto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.example.crypto.core.navigation.AdaptiveCoinListDetailPan
import com.example.crypto.core.navigation.NavigationStack
import com.example.crypto.onboarding.presentation.OnboardingScreen
import com.example.crypto.ui.theme.CryptoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
     //   WindowCompat.setDecorFitsSystemWindows(window, true)
        setContent {
            CryptoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationStack(
                        modifier = Modifier.padding(innerPadding)
                            .safeContentPadding()
                    )

                    //OnboardingScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

