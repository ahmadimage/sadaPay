package com.wallet.sadapay.ui.Splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.wallet.sadapay.R
import com.wallet.sadapay.navigation.Screen
import com.wallet.sadapay.ui.theme.OrangePrimary
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
    // Set the status bar color
    val statusBarColor = Color.Red // Replace with your desired color
    val darkIcons = statusBarColor == Color.White // Set to true if statusBarColor is light
    systemUiController.setStatusBarColor(
        color = OrangePrimary,
        darkIcons = darkIcons
    )
    var startAnimation by remember { mutableStateOf(false)}
    val alphaAnim = animateFloatAsState(
        targetValue = if(startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(Screen.Login.route)
    }

    SplashScreen(alphaAnim.value)
}

@Composable
fun SplashScreen(
    alpha: Float
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
                .alpha(alpha),
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