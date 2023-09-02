package com.wallet.sadapay.ui.msisdn.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
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
            text = stringResource(id = R.string.we_ve_sent_it_to_v) + " $msisdn"
        )
        FourTextInputFields()
    }
}

@Composable
fun FourTextInputFields() {
    var otp1 by remember { mutableStateOf("") }
    var otp2 by remember { mutableStateOf("") }
    var otp3 by remember { mutableStateOf("") }
    var otp4 by remember { mutableStateOf("") }

    otp1 = otpInputField()

    ScreenSubtitle(modifier = Modifier, text = otpInputField())

}

@Composable
fun otpInputField(): String {
    var text by remember { mutableStateOf("") }
    BasicTextField(
        value = text,
        onValueChange = { newString -> text = newString},
        singleLine = true,
        textStyle = LocalTextStyle.current.copy(
            color = Color.Black
        ),
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
    )
    return text
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