package com.example.crypto.core.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crypto.onboarding.presentation.OnboardingScreen

@Composable
fun NavigationStack (modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Oboarding.route) {
        composable(route = Screen.Oboarding.route,
            exitTransition = {
                when (targetState.destination.route) {
                    Screen.Crypto.route ->
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(500)
                        )

                    else -> null
                }
            }
            ) {
            OnboardingScreen(
                navController
            )
        }
        composable(route = Screen.Crypto.route) {
            AdaptiveCoinListDetailPan()
        }
    }

}
