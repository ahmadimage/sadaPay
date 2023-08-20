package com.wallet.sadapay.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.wallet.sadapay.ui.Splash.AnimatedSplashScreen
import com.wallet.sadapay.ui.Splash.SplashScreen
import com.wallet.sadapay.ui.msisdn.LoginScreen

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
            LoginScreen()
        }
    }
}