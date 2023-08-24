package com.wallet.sadapay.ui.msisdn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wallet.sadapay.ui.theme.OrangePrimary

@Composable
fun LoginMsisdnScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(OrangePrimary)
            .padding(20.dp)
    ){
        ScreenTitle(modifier = Modifier, title = "Lets get started!")
    }
}

@Composable
fun ScreenTitle(modifier: Modifier, title: String) {
    Column(
        modifier = modifier.padding(vertical = 20.dp)
    ) {
        Text(
            text = title,
            fontSize = MaterialTheme.typography.h4.fontSize,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LanguagePreview() {
    LoginMsisdnScreen()
}
