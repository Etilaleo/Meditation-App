package com.example.meditationapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationapp.ui.theme.MainBackgroundColor
import com.example.meditationapp.ui.theme.White

@Preview(showBackground = true)
@Composable
fun SecondDefaultPreview() {
    HomeScreen()
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .background(color = MainBackgroundColor)
            .padding(18.dp)
    ) {
        TopBar()
    }
}

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Good Morning, Leonard",
                    fontSize = 20.sp,
                    color = White
                )
                Text(
                    text = "We wish you have a good day",
                    fontSize = 15.sp,
                    color = White
                )
            }
        }
    }
}