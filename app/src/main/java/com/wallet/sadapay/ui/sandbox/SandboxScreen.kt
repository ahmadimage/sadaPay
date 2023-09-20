package com.wallet.sadapay.ui.sandbox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.wallet.sadapay.R
import com.wallet.sadapay.ui.theme.HeaderStyle

@Composable
fun SandboxScreen() {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = colorResource(id = R.color.purple_FF9360FF),
        darkIcons = false
    )
    TestScrollableColumn()
}

@Composable
fun TestScrollableColumn() {
    val state = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.purple_FFF5F0FF))
            .padding(20.dp)
            .verticalScroll(state)
    ) {
        Heading("Ahmad Zaheer")
        Spacer(modifier = Modifier.height(8.dp))
        SubHeading(text = stringResource(id = R.string.grade))
        Spacer(modifier = Modifier.height(16.dp))
        HeadingUnderLined(text = stringResource(id = R.string.professional_summary))
        Spacer(modifier = Modifier.height(8.dp))
        Paragraph(text = stringResource(id = R.string.lorem_ipsum))
        Spacer(modifier = Modifier.height(8.dp))
        HeadingUnderLined(text = stringResource(id = R.string.experiences))
        Spacer(modifier = Modifier.height(8.dp))
        ExperiencesBlock(company = stringResource(id = R.string.company), from = "Aug 2020", to = "Aug 2021")
        Spacer(modifier = Modifier.height(8.dp))
        ExperiencesBlock(company = stringResource(id = R.string.company), from = "Aug 2020", to = "Aug 2021")
        Spacer(modifier = Modifier.height(8.dp))
        ExperiencesBlock(company = stringResource(id = R.string.company), from = "Aug 2020", to = "Aug 2021")
        Spacer(modifier = Modifier.height(8.dp))
        ExperiencesBlock(company = stringResource(id = R.string.company), from = "Aug 2020", to = "Aug 2021")
        Spacer(modifier = Modifier.height(8.dp))
        ExperiencesBlock(company = stringResource(id = R.string.company), from = "Aug 2020", to = "Aug 2021")
        Spacer(modifier = Modifier.height(8.dp))
        ExperiencesBlock(company = stringResource(id = R.string.company), from = "Aug 2020", to = "Aug 2021")
        Spacer(modifier = Modifier.height(8.dp))
        ExperiencesBlock(company = stringResource(id = R.string.company), from = "Aug 2020", to = "Aug 2021")
        Spacer(modifier = Modifier.height(8.dp))
        HeadingUnderLined(text = stringResource(id = R.string.skills))
        Spacer(modifier = Modifier.height(6.dp))
        BulletText(text = "skill")
        Spacer(modifier = Modifier.height(8.dp))
        BulletText(text = "skill")
        Spacer(modifier = Modifier.height(8.dp))
        BulletText(text = "skill")
        Spacer(modifier = Modifier.height(8.dp))
        BulletText(text = "skill")
        Spacer(modifier = Modifier.height(8.dp))
        BulletText(text = "skill")
        Spacer(modifier = Modifier.height(8.dp))
        BulletText(text = "skill")
        Spacer(modifier = Modifier.height(8.dp))
        BulletText(text = "skill")
        Spacer(modifier = Modifier.height(8.dp))
        BulletText(text = "issue")
        Spacer(modifier = Modifier.height(8.dp))
        HeadingUnderLined(text = stringResource(id = R.string.languages))
        Spacer(modifier = Modifier.height(6.dp))
        BulletText(text = "urdu")
        Spacer(modifier = Modifier.height(8.dp))
        BulletText(text = "urdu")
        Spacer(modifier = Modifier.height(8.dp))
        BulletText(text = "urdu")
        Spacer(modifier = Modifier.height(8.dp))
        BulletText(text = "urdu")
        Spacer(modifier = Modifier.height(8.dp))
        BulletText(text = "urdu")
        Spacer(modifier = Modifier.height(8.dp))
        BulletText(text = "urdu")
        Spacer(modifier = Modifier.height(8.dp))
        BulletText(text = "urdu")
        Spacer(modifier = Modifier.height(8.dp))
        BulletText(text = "ubbi dubbi")
        Spacer(modifier = Modifier.height(8.dp))
        HeadingUnderLined(text = stringResource(id = R.string.hobbies))
        Spacer(modifier = Modifier.height(6.dp))
        BulletText(text = "work")
        Spacer(modifier = Modifier.height(8.dp))
        BulletText(text = "work")
        Spacer(modifier = Modifier.height(8.dp))
        BulletText(text = "work")
        Spacer(modifier = Modifier.height(8.dp))
        BulletText(text = "work")
        Spacer(modifier = Modifier.height(8.dp))
        BulletText(text = "work")
        Spacer(modifier = Modifier.height(8.dp))
        BulletText(text = "work")
        Spacer(modifier = Modifier.height(8.dp))
        BulletText(text = "work")
        Spacer(modifier = Modifier.height(8.dp))
        BulletText(text = "more work")
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun Heading(text: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            style = HeaderStyle.h2
        )
    }
}

@Composable
fun SubHeading(text: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            style = HeaderStyle.body1
        )
    }
}

@Composable
fun HeadingUnderLined(text: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            style = HeaderStyle.h3
        )
    }
}

@Composable
fun Paragraph(text: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            text = text,
            style = HeaderStyle.body1
        )
    }
}

@Composable
fun ExperiencesBlock(company: String, from: String, to: String) {
    Column {
        Text(
            text = company,
            style = HeaderStyle.body1,
            fontWeight = FontWeight.W500
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "$from - $to",
            style = HeaderStyle.body1,
            fontWeight = FontWeight.W500,
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(6.dp))
        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = colorResource(id = R.color.grey_EBE7E7)
        )
    }
}

@Composable
fun BulletText(text: String) {
    val bullet = "\u2022"
    Text(
        text = "$bullet\t$text",
        style = HeaderStyle.body1
    )
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
