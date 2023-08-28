package com.wallet.sadapay.navigation

import com.wallet.sadapay.util.LOGIN_SCREEN
import com.wallet.sadapay.util.SPLASH_SCREEN
import com.wallet.sadapay.util.VERIFICATION_SCREEN

const val MSISDN_ARGUMENT_KEY = "msisdn"

sealed class Screen(val route: String) {
    object Splash: Screen(SPLASH_SCREEN)
    object Login: Screen(LOGIN_SCREEN)
    object LoginVerification: Screen("$VERIFICATION_SCREEN/{$MSISDN_ARGUMENT_KEY}") {
        fun passMsisdn(msisdn: String): String {
            return "$VERIFICATION_SCREEN/{$msisdn}"
        }
    }
}