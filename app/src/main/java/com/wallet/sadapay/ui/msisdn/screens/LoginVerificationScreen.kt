package com.wallet.sadapay.ui.msisdn.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.wallet.sadapay.R
import com.wallet.sadapay.ui.theme.OrangePrimary

@Composable
fun LoginVerificationScreen(navController: NavController, msisdn: String ?= "") {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(OrangePrimary)
            .padding(20.dp)
    ) {
        BackButton(navController)
        ScreenTitle(modifier = Modifier, title = stringResource(id = R.string.enter_verification_code))
        ScreenSubtitle(
            modifier = Modifier,
            text = stringResource(id = R.string.we_ve_sent_it_to_v) + msisdn
        )
    }
}

@Composable
fun BackButton(navController: NavController) {
    Image(
        painter = painterResource(id = R.drawable.ic_boneless_arrow_left),
        contentDescription = stringResource(id = R.string.ic_nav_back_desc),
        modifier = Modifier.clickable(
            interactionSource = remember { MutableInteractionSource() }, //mandatory
            indication = null //removes goofy aah ripple
        ) {
            navController.popBackStack()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun LoginVerificationScreenPreview() {
    LoginVerificationScreen(rememberNavController())
}