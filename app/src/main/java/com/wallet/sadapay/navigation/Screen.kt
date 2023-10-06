package com.wallet.sadapay.navigation

import com.wallet.sadapay.util.*

const val MSISDN_ARGUMENT_KEY = "msisdn"

sealed class Screen(val route: String) {
    object Splash: Screen(SPLASH_SCREEN)
    object Login: Screen(LOGIN_SCREEN)
    object Sandbox: Screen(SANDBOX_SCREEN)
    object Assignment2: Screen(ASSIGNMENT_2)
    object Assignment3: Screen(ASSIGNMENT_3)
    object LoginVerification: Screen("$VERIFICATION_SCREEN/{$MSISDN_ARGUMENT_KEY}") {
        fun passMsisdn(msisdn: String): String {
            return "$VERIFICATION_SCREEN/$msisdn"
        }
    }
}