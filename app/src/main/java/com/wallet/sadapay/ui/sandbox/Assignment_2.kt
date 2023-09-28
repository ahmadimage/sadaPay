package com.wallet.sadapay.ui.sandbox

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.wallet.sadapay.R
import com.wallet.sadapay.ui.theme.HeaderStyle

@Composable
fun Assignment_2() {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = colorResource(id = R.color.black_455059),
        darkIcons = false
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black_101010))
    )
    {
        TopImage()
        //ToolBarComposable()
        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(100.dp))
            NameAndLocation()
        }
    }
}

@Composable
fun NameAndLocation() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 19.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .shadow(elevation = 2.dp, shape = RoundedCornerShape(8.dp), ambientColor = Color.Red),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.white)
                ),
                elevation = CardDefaults.cardElevation()
            ) {
                Spacer(modifier = Modifier.height(45.dp))
                Text(
                    text = "Darth Vader",
                    style = HeaderStyle.h2,
                    fontSize = HeaderStyle.h2.fontSize,
                    textAlign = TextAlign.Center
                )
            }
        }
        Image(
            modifier = Modifier
                .clip(CircleShape)
                .width(80.dp)
                .height(80.dp)
                .align(Alignment.TopCenter),
            painter = painterResource(id = R.drawable.ic_pk),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolBarComposable() {
    TopAppBar(
        title = { Text(text = "My App") },
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_boneless_arrow_left), // Replace with your navigation icon
                contentDescription = null,
                //modifier = Modifier.clickable { /* Handle navigation here */ }
            )
        },
        actions = {
            // Add action icons here
            Icon(
                painter = painterResource(id = R.drawable.ic_more), // Replace with your action icon
                contentDescription = null,
                //modifier = Modifier.clickable { /* Handle action here */ }
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = colorResource(id = R.color.black_455059),
            contentColorFor(backgroundColor = Color.White)
        )
        /*backgroundColor = MaterialTheme.colorScheme.primary,
        contentColor = Color.White*/
    )
}

@Composable
fun TopImage() {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp),
        shape = RoundedCornerShape(bottomStart = 150.dp, bottomEnd = 150.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.black_455059)
        )
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun Assignment2Preview() {
    Assignment_2()
}