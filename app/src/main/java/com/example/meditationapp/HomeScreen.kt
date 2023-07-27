package com.example.meditationapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationapp.ui.theme.AllButtonColors
import com.example.meditationapp.ui.theme.FeaturedCardColors1
import com.example.meditationapp.ui.theme.FeaturedCardColors2
import com.example.meditationapp.ui.theme.FeaturedCardColors3
import com.example.meditationapp.ui.theme.FeaturedCardColors4
import com.example.meditationapp.ui.theme.MainBackgroundColor
import com.example.meditationapp.ui.theme.SelectedMedType
import com.example.meditationapp.ui.theme.UnselectedMedType
import com.example.meditationapp.ui.theme.White

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HomeScreen()
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .background(color = MainBackgroundColor)
            .padding(18.dp)
    ) {
        GreetingTopBar()
        TypeOfMeditation(
            listOf(
                MeditationType(0, "Sweet sleep"),
                MeditationType(1, "Insomnia"),
                MeditationType(2, "Depression"),
                MeditationType(3, "Anxiety")
            )
        )
        DailyThought(
            firstText = "Daily Thought",
            secondText = "Meditation \u2022 3-10 min"
        )
        Spacer(modifier = Modifier.padding(vertical = 20.dp))
        FeaturedContent(listOf(
            FeaturedMed(
                "Sleep Meditation",
                painterResource(id = R.drawable.ic_headphone),
                FeaturedCardColors1
            ),
            FeaturedMed(
                "Tips for sleeping",
                painterResource(id = R.drawable.ic_videocameta),
                FeaturedCardColors2
            ),
            FeaturedMed(
                "Night island",
                painterResource(id = R.drawable.ic_headphone),
                FeaturedCardColors3
            ),
            FeaturedMed(
                "Calming Sounds",
                painterResource(id = R.drawable.ic_headphone),
                FeaturedCardColors4
            )
        ))
    }
}

//Here is the greeting bar
@Composable
fun GreetingTopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Good Morning, Leonard",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = White
                )
                Text(
                    text = "We wish you have a good day!",
                    fontSize = 15.sp,
                    color = Color.Gray
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null,
                tint = White,
                modifier = Modifier
                    .size(20.dp)
            )
        }
    }
}

@Composable
fun TypeOfMeditation(
    listOfMed: List<MeditationType>
) {
    var ifSelected by remember {
        mutableStateOf(0)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 25.dp)
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(listOfMed) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            if (it.index == ifSelected) {
                                SelectedMedType
                            } else {
                                UnselectedMedType
                            }
                        )
                        .clickable {
                            ifSelected = it.index
                        }
                        .padding(12.dp),
                    contentAlignment = Alignment.Center

                ) {
                    Text(
                        text = it.itemText,
                        color = White,
                        fontSize = 17.sp
                    )
                }
            }
        }
    }
}

@Composable
fun DailyThought(
    firstText: String,
    secondText: String
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(com.example.meditationapp.ui.theme.DailyThought)
            .padding(15.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = firstText,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = White
                )
                Text(
                    text = secondText,
                    fontSize = 15.sp,
                    color = White
                )
            }
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(AllButtonColors)
                    .padding(6.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = null,
                    tint = White
                )
            }
        }
    }
}

@Composable
fun FeaturedContent(
    itemList: List<FeaturedMed>
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Text(
            text = " Featured",
            fontSize = 27.sp,
            color = White,
            fontWeight = FontWeight.Bold
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(itemList) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(it.backgroundColor)
                        .padding(10.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .height(140.dp)
                    ) {
                        Text(
                            text = it.itemText,
                            fontSize = 20.sp,
                            color = White,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Icon(
                                painter = it.icon,
                                contentDescription = null,
                                tint = White,
                                modifier = Modifier
                                    .size(24.dp)
                            )
                            Box(
                                modifier = Modifier
                                    .size(width = 60.dp, height = 30.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(AllButtonColors)
                                    .padding(6.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Start",
                                    color = White
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}