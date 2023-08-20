package com.wallet.sadapay.ui.Splash

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.wallet.sadapay.R
import com.wallet.sadapay.navigation.Screen
import com.wallet.sadapay.ui.theme.OrangePrimary

@Composable
fun AnimatedSplashScreen(navController: NavController) {
    val context = LocalContext.current
    val view = LocalView.current
    val systemUiController = rememberSystemUiController()

    // Set the status bar color
    val statusBarColor = Color.Red // Replace with your desired color
    val darkIcons = statusBarColor == Color.White // Set to true if statusBarColor is light

    systemUiController.setStatusBarColor(
        color = OrangePrimary,
        darkIcons = darkIcons
    )

    SplashScreen(navController = navController)
}

@Composable
fun SplashScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = OrangePrimary),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .clickable {
                    navController.navigate(Screen.Login.route)
                },
            painter = painterResource(R.drawable.ic_card),
            contentDescription = "language logo"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    AnimatedSplashScreen(rememberNavController())
}