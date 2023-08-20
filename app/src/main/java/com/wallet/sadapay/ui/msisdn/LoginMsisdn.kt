package com.wallet.sadapay.ui.msisdn

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "login screen",
            fontSize = MaterialTheme.typography.h3.fontSize,
            color = MaterialTheme.colors.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LanguagePreview() {
    LoginScreen()
}
