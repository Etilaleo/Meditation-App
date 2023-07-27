package com.example.meditationapp

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

data class FeaturedMed(
    val itemText : String,
    val icon : Painter,
    val backgroundColor : Color
)
