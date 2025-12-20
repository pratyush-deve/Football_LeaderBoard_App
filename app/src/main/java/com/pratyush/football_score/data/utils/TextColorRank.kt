package com.pratyush.football_score.data.utils

import androidx.compose.ui.graphics.Color

fun TextColorRank(rank: Int): Color {
    return when {
        rank == 1 -> Color(0xFF1A1A1A)
        rank in 2..4->Color.White
        rank == 5 -> Color(0xFF1A1A1A)
        rank == 6 -> Color(0xFF0F2A0F)
        else -> Color.White
    }
}