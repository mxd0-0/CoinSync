package com.example.crypto.core.navigation

sealed class Screen(
    val route: String
) {
    object Crypto : Screen("crypto")
    object Oboarding : Screen("onboarding")
}