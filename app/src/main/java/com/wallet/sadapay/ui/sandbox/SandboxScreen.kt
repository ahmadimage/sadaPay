package com.wallet.sadapay.ui.sandbox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wallet.sadapay.R
import com.wallet.sadapay.ui.theme.OrangePrimary

@Composable
fun SandboxScreen() {
    TestScrollableColumn()
}

@Composable
fun TestScrollableColumn() {
    val state = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(OrangePrimary)
            .padding(20.dp)
            .verticalScroll(state)
    ) {
        HelloWorld()
        HelloWorld()
        HelloWorld()
        HelloWorld()
        HelloWorld()
        HelloWorld()
        HelloWorld()
        HelloWorld()
        HelloWorld()
        HelloWorld()
        HelloWorld()
        HelloWorld()
        HelloWorld()
        HelloWorld()
        HelloWorld()
        HelloWorld()
        HelloWorld()
        HelloWorld()
        HelloWorld()
        HelloWorld()
    }
}

@Composable
fun HelloWorld() {
    Text(
        text = stringResource(id = R.string.get_started),
        fontSize = 30.sp,
        color = Color.White,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(10.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun TestScrollableColumnPreview() {
    TestScrollableColumn()
}
