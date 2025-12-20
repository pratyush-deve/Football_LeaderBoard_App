package com.pratyush.football_score.data.utils

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

object DetailGradients {

    val Rank = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFF6B5B3E),
            Color(0xFF3E3222)
        )
    )
    val Points = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFF5A3A82),
            Color(0xFF3A2359)
        )
    )
    val Wins = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFF1E6A5A),
            Color(0xFF123F37)
        )
    )
    val Losses = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFF6A2A3C),
            Color(0xFF3F1622)
        )
    )
    val Draws = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFF2E3E55),
            Color(0xFF1C2636)
        )
    )
    val GamesPlayed = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFF0F4C75),
            Color(0xFF08304A)
        )
    )
}

