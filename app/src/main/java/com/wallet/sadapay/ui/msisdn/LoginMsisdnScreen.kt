package com.wallet.sadapay.ui.msisdn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.wallet.sadapay.R
import com.wallet.sadapay.ui.theme.OrangePrimary

@Composable
fun LoginMsisdnScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(OrangePrimary)
            .padding(20.dp)
    ){
        ScreenTitle(modifier = Modifier, title = stringResource(id = R.string.get_started))
        ScreenSubtitle(modifier = Modifier, text = stringResource(id = R.string.enter_mobile_number))
        //DropdownMenuExample()
        CountrySelectPill(modifier = Modifier)
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
        modifier = modifier.padding(10.dp),
        shape = RoundedCornerShape(60),
        elevation = CardDefaults.cardElevation(),
    ) {
        ConstraintLayout(
            modifier = Modifier
                .padding(16.dp)
        ) {
            val (item1, item2, item3) = createRefs()

            Text(
                text = "Item 1",
                modifier = Modifier.constrainAs(item1) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
            )

            Text(
                text = "Item 2",
                modifier = Modifier.constrainAs(item2) {
                    start.linkTo(item1.end, 16.dp)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
            )

            Text(
                text = "Item 3",
                modifier = Modifier.constrainAs(item3) {
                    start.linkTo(item2.end, 16.dp)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
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

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginMsisdnScreen()
}
