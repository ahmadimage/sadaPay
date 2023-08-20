package com.wallet.sadapay.navigation

import com.wallet.sadapay.util.LOGIN_SCREEN
import com.wallet.sadapay.util.SPLASH_SCREEN

sealed class Screen(val route: String) {
    object Splash: Screen(SPLASH_SCREEN)
    object Login: Screen(LOGIN_SCREEN)
}