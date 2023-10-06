package com.wallet.sadapay.ui.sandbox

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
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
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.wallet.sadapay.R
import com.wallet.sadapay.ui.theme.HeaderStyle

@Composable
fun Assignment_3() {
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
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            item {
                Spacer(modifier = Modifier.height(100.dp))
                ProfileCard()
            }
            item {
                Spacer(modifier = Modifier.height(30.dp))
                SocialInfo()
            }
            item {
                Spacer(modifier = Modifier.height(30.dp))
                SquadronInfo()
            }
            item {
                Spacer(modifier = Modifier.height(30.dp))
                StaggeredImageView()
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
        CustomToolbar()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StaggeredImageView() {
    val data = randomSizedPhotos
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 19.dp, end = 19.dp)
            .height(310.dp)
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
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            contentPadding = PaddingValues(12.dp),
            content = {
                items(data.size) { index ->
                    SubcomposeAsyncImage(
                        data[index],
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(5.dp)
                            .clip(RoundedCornerShape(5)),
                        contentScale = ContentScale.Crop,
                        loading = {
                            CircularProgressIndicator(color = colorResource(id = R.color.red_vader))
                        },
                    )
                }
            }
        )
    }
}

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
            ConstraintLayout(modifier = Modifier.fillMaxSize()){
                val (tvName, comLocation, btnFollow) = createRefs()
                Text(
                    text = name,
                    style = HeaderStyle.h2,
                    fontSize = HeaderStyle.h2.fontSize,
                    modifier = Modifier
                        .padding(top = 60.dp)
                        .constrainAs(tvName) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(parent.top)
                        }
                )
                Box(modifier = Modifier
                    .padding(top = 5.dp)
                    .constrainAs(comLocation) {
                        start.linkTo(parent.start)
                        top.linkTo(tvName.bottom)
                        end.linkTo(parent.end)
                    }) {
                    LocationView(location = location)
                }
                Button(
                    modifier = Modifier
                        .constrainAs(btnFollow) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(comLocation.bottom)
                        }
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
    ConstraintLayout {
        val (ivLocation, tvLocation) = createRefs()
        Icon(
            imageVector = Icons.Default.LocationOn,
            contentDescription = stringResource(id = R.string.location_icon_desc),
            tint = colorResource(id = R.color.red_vader),
            modifier = Modifier
                .height(15.dp)
                .constrainAs(ivLocation) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
        )

        Text(
            text = location,
            style = HeaderStyle.body1,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(start = 3.dp)
                .constrainAs(tvLocation) {
                    start.linkTo(ivLocation.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
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
    ){
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(19.dp)) {
            val (tvSoldiers, tvSeeAll, comSoldiers) = createRefs()

            Text(
                text = stringResource(id = R.string.soldiers),
                style = HeaderStyle.h2,
                modifier = Modifier.constrainAs(tvSoldiers) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
            )
            Text(
                text = stringResource(id = R.string.see_all),
                style = HeaderStyle.body2,
                fontSize = 12.sp,
                modifier = Modifier.constrainAs(tvSeeAll) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }
            )
            LazyRow(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth()
                    .constrainAs(comSoldiers) {
                        start.linkTo(parent.start)
                        top.linkTo(tvSoldiers.bottom)
                        end.linkTo(parent.end)
                    },
                horizontalArrangement = Arrangement.SpaceBetween)
            {
                items(5) {
                    UserImageName(name = stringResource(id = R.string.droid), userImage = R.drawable.ic_death_star_bold)
                }
            }
        }
    }
}

@Composable
fun UserImageName(name: String, userImage: Int) {
    ConstraintLayout {
        val (ivUserImage, tvUserName) = createRefs()
        Image(
            painter = painterResource(id = userImage),
            contentDescription = stringResource(id = R.string.soldiers),
            modifier = Modifier
                .clip(CircleShape)
                .size(40.dp)
                .constrainAs(ivUserImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Text(
            text = name,
            style = HeaderStyle.body2,
            fontSize = 13.sp,
            modifier = Modifier.constrainAs(tvUserName) {
                top.linkTo(ivUserImage.bottom)
                start.linkTo(ivUserImage.start)
                end.linkTo(ivUserImage.end)
            }
        )
    }
    /*Column(
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
    }*/
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
    ConstraintLayout {
        val (tvStatName, tvCount) = createRefs()
        Text(
            modifier = Modifier.constrainAs(tvCount) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            },
            text = count,
            style = HeaderStyle.h2,
        )
        Text(
            modifier = Modifier
                .padding(top = 10.dp)
                .constrainAs(tvStatName) {
                    start.linkTo(tvCount.start)
                    end.linkTo(tvCount.end)
                    top.linkTo(tvCount.bottom)
                },
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



fun randomSampleImageUrl(
    seed: Int = (0..20).random(),
    width: Int = 300,
    height: Int = width,
): String {
    return "https://picsum.photos/seed/$seed/$width/$height"

}

val randomSizedPhotos = listOf(
    randomSampleImageUrl(width = 1600, height = 900),
    randomSampleImageUrl(width = 900, height = 1600),
    randomSampleImageUrl(width = 500, height = 500),
    randomSampleImageUrl(width = 300, height = 400),
    randomSampleImageUrl(width = 1600, height = 900),
    randomSampleImageUrl(width = 500, height = 500),
    randomSampleImageUrl(width = 1600, height = 900),
    randomSampleImageUrl(width = 900, height = 1600),
    randomSampleImageUrl(width = 500, height = 500),
    randomSampleImageUrl(width = 300, height = 400),
    randomSampleImageUrl(width = 1600, height = 900),
    randomSampleImageUrl(width = 500, height = 500),
    randomSampleImageUrl(width = 900, height = 1600),
    randomSampleImageUrl(width = 500, height = 500),
    randomSampleImageUrl(width = 300, height = 400),
    randomSampleImageUrl(width = 1600, height = 900),
    randomSampleImageUrl(width = 500, height = 500),
    randomSampleImageUrl(width = 500, height = 500),
    randomSampleImageUrl(width = 300, height = 400),
    randomSampleImageUrl(width = 1600, height = 900),
    randomSampleImageUrl(width = 500, height = 500),
    randomSampleImageUrl(width = 900, height = 1600),
    randomSampleImageUrl(width = 500, height = 500),
    randomSampleImageUrl(width = 300, height = 400),
    randomSampleImageUrl(width = 1600, height = 900),
    randomSampleImageUrl(width = 500, height = 500),
)

@Preview(showBackground = true)
@Composable
fun Assignment3Preview() {
    Assignment_3()
}