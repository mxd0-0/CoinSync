package com.example.crypto.onboarding.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.crypto.R
import com.example.crypto.core.navigation.Screen
import com.example.crypto.ui.theme.CryptoTheme
import com.example.crypto.ui.theme.backgroundDark
import com.example.crypto.ui.theme.primaryLight

@Composable
fun OnboardingScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val description =
        "Track real-time crypto prices, stay ahead of market\n trends,and never miss an opportunity."
    val title = "Welcome to \nCoinSync"
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundDark)
            .consumeWindowInsets(
                WindowInsets.systemBars.only(WindowInsetsSides.Vertical)
            )
            .safeContentPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(
                R.drawable.coveronboarding
            ),
            contentDescription = null,
            modifier = modifier.fillMaxWidth()
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            AnimatedContent(
                targetState = title,
                modifier = Modifier.align(
                    Alignment.CenterHorizontally
                ),
                label = title
            ) {
                Text(
                    it,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.displayMedium,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
            AnimatedContent(
                targetState = description,
                modifier = Modifier.align(
                    Alignment.CenterHorizontally
                ),
                label = "IconAnimation"
            ) {
                Text(
                    it,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
            Button(
                onClick = { navController.navigate(
                    route = Screen.Crypto.route
                ){
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = true
                    }
                } },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = primaryLight,
                    contentColor = Color.White
                ),
                shape = MaterialTheme.shapes.large
            ) {
                Text(
                    "Get Started",
                    style = MaterialTheme.typography.titleLarge
                )
            }

        }

    }
}


@Preview
@Composable
private fun OnboardingScreenPrev() {
    CryptoTheme {
       // OnboardingScreen()
    }
}