package com.wallet.sadapay.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.wallet.sadapay.ui.Splash.AnimatedSplashScreen
import com.wallet.sadapay.ui.msisdn.screens.LoginMsisdnScreen
import com.wallet.sadapay.ui.msisdn.screens.LoginVerificationScreen
import com.wallet.sadapay.ui.sandbox.SandboxScreen

@Composable
fun SetupNavGraph(
    navHostController: NavHostController
){
    NavHost(
        navController = navHostController,
        startDestination = Screen.Splash.route
    ) {
        composable(
            route = Screen.Splash.route
        ){
            //SplashScreen(navController = navHostController)
            AnimatedSplashScreen(navController = navHostController)
        }
        composable(
            route = Screen.Login.route
        ){
            LoginMsisdnScreen(navController = navHostController)
        }
        composable(
            route = Screen.LoginVerification.route,
            arguments = listOf(navArgument(MSISDN_ARGUMENT_KEY){
                type = NavType.StringType
                defaultValue = ""
            })
        ){
            LoginVerificationScreen(navController = navHostController, it.arguments?.getString(MSISDN_ARGUMENT_KEY))
        }
        composable(
            route = Screen.Sandbox.route
        ) {
            SandboxScreen()
        }
    }
}