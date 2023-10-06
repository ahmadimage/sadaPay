package com.wallet.sadapay.ui.sandbox

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        /*TopImage()
        //ToolBarComposable()
        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(100.dp))
            //NameAndLocation()
            ProfileCard()
            Spacer(modifier = Modifier.height(30.dp))
            SocialInfo()
            Spacer(modifier = Modifier.height(30.dp))
            SquadronInfo()
        }
        CustomToolbar()*/
    }
}

/*
@Composable
fun ProfileCard(name: String = "Darth Vader", location: String = "Near Alderaan"){
    Box(
        contentAlignment = Alignment.TopCenter
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 47.dp, start = 19.dp, end = 19.dp)
                .height(200.dp)
                .shadow(
                    elevation = 50.dp,
                    shape = RoundedCornerShape(8.dp),
                    ambientColor = Color.Red
                ),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.white)
            ),
            elevation = CardDefaults.cardElevation()
        )
        {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = name,
                    style = HeaderStyle.h2,
                    fontSize = HeaderStyle.h2.fontSize
                )
                Spacer(modifier = Modifier.height(5.dp))
                LocationView(location = location)
                Button(
                    modifier = Modifier
                        .padding(19.dp)
                        .shadow(
                            elevation = 10.dp,
                            spotColor = colorResource(id = R.color.red_vader),
                            shape = MaterialTheme.shapes.extraLarge
                        ),
                    colors = ButtonDefaults.buttonColors(
                        colorResource(id = R.color.black_455059)
                    ),
                    onClick = {

                    }
                ) {
                    Text(text = stringResource(id = R.string.follow))
                }
            }
        }

        Image(
            modifier = Modifier
                .clip(CircleShape)
                .width(80.dp)
                .height(80.dp)
                .align(Alignment.TopCenter),
            painter = painterResource(id = R.drawable.ic_death_star_bold),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun LocationView(location: String) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.Default.LocationOn,
            contentDescription = stringResource(id = R.string.location_icon_desc),
            tint = colorResource(id = R.color.red_vader),
            modifier = Modifier.height(15.dp)
        )
        Spacer(
            modifier = Modifier.width(2.dp)
        )
        Text(
            text = location,
            style = HeaderStyle.body1,
            fontSize = 14.sp
        )
    }
}

@Composable
fun SocialInfo() {
    Card( modifier = Modifier
        .fillMaxWidth()
        .padding(start = 19.dp, end = 19.dp)
        .height(110.dp)
        .shadow(
            elevation = 50.dp,
            shape = RoundedCornerShape(8.dp),
            ambientColor = Color.Red
        ),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.white)
        ),
        elevation = CardDefaults.cardElevation()
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StatInfoColumn(count = "100.1M", statName = stringResource(id = R.string.soldiers))
            DividerCustom()
            StatInfoColumn(count = "12.1M", statName = stringResource(id = R.string.droids))
            DividerCustom()
            StatInfoColumn(count = "4 M", statName = stringResource(id = R.string.prisoners))
        }
    }
}

@Composable
fun SquadronInfo() {
    Card( modifier = Modifier
        .fillMaxWidth()
        .padding(start = 19.dp, end = 19.dp)
        .height(130.dp)
        .shadow(
            elevation = 50.dp,
            shape = RoundedCornerShape(8.dp),
            ambientColor = Color.Red
        ),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.white)
        ),
        elevation = CardDefaults.cardElevation()
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(19.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.soldiers),
                    style = HeaderStyle.h2,
                )
                Text(
                    text = stringResource(id = R.string.see_all),
                    style = HeaderStyle.body2,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween)
            {
                UserImageName(name = stringResource(id = R.string.droid), userImage = R.drawable.ic_death_star_bold)
                UserImageName(name = stringResource(id = R.string.droid), userImage = R.drawable.ic_death_star_bold)
                UserImageName(name = stringResource(id = R.string.droid), userImage = R.drawable.ic_death_star_bold)
                UserImageName(name = stringResource(id = R.string.droid), userImage = R.drawable.ic_death_star_bold)
                UserImageName(name = stringResource(id = R.string.droid), userImage = R.drawable.ic_death_star_bold)
            }
        }
    }
}

@Composable
fun UserImageName(name: String, userImage: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = userImage),
            contentDescription = stringResource(id = R.string.soldiers),
            modifier = Modifier
                .clip(CircleShape)
                .size(40.dp)
        )
        Text(
            text = name,
            style = HeaderStyle.body2,
            fontSize = 13.sp
        )
    }
}

@Composable
fun DividerCustom() {
    Divider(
        modifier = Modifier
            .fillMaxHeight()
            .width(1.dp)
            .padding(vertical = 10.dp),
        color = colorResource(id = R.color.red_vader)
    )
}

@Composable
fun StatInfoColumn(count: String, statName: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = count,
            style = HeaderStyle.h2,
        )
        Text( modifier = Modifier.padding(top = 10.dp),
            text = statName
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomToolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Image(painter = painterResource(
            id = R.drawable.ic_boneless_arrow_left), contentDescription = stringResource(
            id = R.string.ic_nav_back_desc
        ))
        Text(
            text = stringResource(id = R.string.profile),
            style = HeaderStyle.h2,
            color = Color.White,
            fontSize = HeaderStyle.h2.fontSize
        )
        Image(painter = painterResource(
            id = R.drawable.ic_more), contentDescription = stringResource(
            id = R.string.ic_nav_back_desc
        ), Modifier.height(35.dp))
    }
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
}*/
