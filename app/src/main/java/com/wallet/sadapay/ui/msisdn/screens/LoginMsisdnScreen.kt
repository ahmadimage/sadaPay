package com.wallet.sadapay.ui.msisdn.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wallet.sadapay.R
import com.wallet.sadapay.ui.msisdn.viewmodel.LoginViewModel
import com.wallet.sadapay.ui.theme.Cyan_01d3b0
import com.wallet.sadapay.ui.theme.GreyHint
import com.wallet.sadapay.ui.theme.OrangePrimary

@Composable
fun LoginMsisdnScreen() {
    val viewModel: LoginViewModel = viewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(OrangePrimary)
            .padding(20.dp)
    ){
        ScreenTitle(modifier = Modifier, title = stringResource(id = R.string.get_started))
        ScreenSubtitle(modifier = Modifier, text = stringResource(id = R.string.enter_mobile_number))
        //DropdownMenuExample()
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            CountrySelectPill(modifier = Modifier)
            Spacer(modifier = Modifier.width(8.dp))
            MsisdnField(modifier = Modifier, viewModel = viewModel)
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        ContinueButton(
            modifier = Modifier,
            isButtonEnabled = viewModel.msisdnFieldValue.value.isNotEmpty()
        ) {

        }
    }
}

@Composable
fun ScreenTitle(modifier: Modifier, title: String) {
    Column(
        modifier = modifier.padding(top = 40.dp)
    ) {
        Text(
            text = title,
            fontSize = MaterialTheme.typography.h4.fontSize,
            color = Color.White,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun ScreenSubtitle(modifier: Modifier, text: String) {
    Column(
        modifier = modifier.padding(vertical = 12.dp)
    ) {
        Text(
            text = text,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            color = Color.White,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun CountrySelectPill(modifier: Modifier) {
    Card(
        modifier = modifier.height(38.dp),
        shape = RoundedCornerShape(60),
        elevation = CardDefaults.cardElevation(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 7.dp)
        ) {
            val (ivFlag, tvCountryCode, ivArrow) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.ic_pk),
                contentDescription = stringResource(id = R.string.ic_country_desc),
                modifier = Modifier
                    .constrainAs(ivFlag) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                    .width(15.dp)
                    .height(13.dp)
            )

            Text(
                text = "+92",
                modifier = Modifier.constrainAs(tvCountryCode) {
                    start.linkTo(ivFlag.end, 5.dp)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
                fontSize = MaterialTheme.typography.body2.fontSize
            )

            Image(
                modifier = modifier
                    .constrainAs(ivArrow) {
                        start.linkTo(tvCountryCode.end, 2.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                    .width(24.dp)
                    .height(24.dp),
                painter = painterResource(id = R.drawable.iv_arrow_drop_down),
                contentDescription = stringResource(id = R.string.ic_drop_down_desc)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MsisdnField(modifier: Modifier, viewModel: LoginViewModel) {
    var msisdn by remember { mutableStateOf("")}
    var hasFocus by remember { mutableStateOf(false)}
    viewModel.msisdnFieldValue.value = msisdn
    val focusRequester = FocusRequester()
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(38.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(60),
        border = if(hasFocus) BorderStroke(2.dp, Cyan_01d3b0) else BorderStroke(2.dp, Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.Center
        ) {
            BasicTextField(
                value = msisdn,
                onValueChange = { newText -> msisdn = newText },
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(fontSize = MaterialTheme.typography.body2.fontSize),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester = focusRequester)
                    .onFocusChanged { isFocused ->
                        hasFocus = isFocused.hasFocus
                    },
                cursorBrush = SolidColor(OrangePrimary),
                decorationBox = { innerTextField ->
                    Row(modifier = Modifier.fillMaxWidth()) {
                        if (msisdn.isEmpty()) {
                            Text(text = "3012345678", color = GreyHint)
                        }
                    }
                    innerTextField()
                }
            )
        }
    }
}

@Composable
fun DropdownMenuExample() {
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("Item 1") }

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Selected Item: $selectedItem")

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.TopStart)
        ) {
            IconButton(onClick = { expanded = true }) {
                Icon(Icons.Default.MoreVert, contentDescription = "Localized description")
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Edit") },
                    onClick = { selectedItem = "edit" },
                    leadingIcon = {
                        Icon(
                            Icons.Outlined.Edit,
                            contentDescription = null
                        )
                    })
                DropdownMenuItem(
                    text = { Text("Settings") },
                    onClick = { /* Handle settings! */ },
                    leadingIcon = {
                        Icon(
                            Icons.Outlined.Settings,
                            contentDescription = null
                        )
                    })

                DropdownMenuItem(
                    text = { Text("Send Feedback") },
                    onClick = { /* Handle send feedback! */ },
                    leadingIcon = {
                        Icon(
                            Icons.Outlined.Email,
                            contentDescription = null
                        )
                    },
                    trailingIcon = { Text("F11", textAlign = TextAlign.Center) })
            }
        }
    }
}

@Composable
fun ContinueButton(
    modifier: Modifier,
    isButtonEnabled: Boolean = false,
    listener:(Boolean) -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(65.dp)
            .alpha(if (isButtonEnabled) 0.3f else 1f),
        onClick = {listener(true)},
        //enabled = isFieldEmpty,
        shape = RoundedCornerShape(20),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
            contentColor = if(isButtonEnabled) OrangePrimary else Color.Cyan
        )
    ) {
        ConstraintLayout(
            modifier = modifier.fillMaxWidth()
        ) {
            val (tvContinue, ivArrow) = createRefs()

            Text(
                modifier = modifier.constrainAs(tvContinue) {
                    start.linkTo(parent.start)
                },
                text = stringResource(id = R.string.btn_continue),
                fontSize = MaterialTheme.typography.h6.fontSize,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
            
            Image(
                modifier = modifier.constrainAs(ivArrow) {
                  end.linkTo(parent.end)
                },
                painter = painterResource(id = R.drawable.ic_arrow_right),
                contentDescription = stringResource(id = R.string.btn_continue_desc))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginMsisdnScreen()
}
