package com.pratyush.football_score.data.utils

import androidx.compose.ui.graphics.Color

fun DetailsBgColor(rank: Int): Color {
    return when {
        rank == 1 -> Color(0xFF16140B)
        rank in 2..4 -> Color(0xFF0E1620)
        rank == 5 -> Color(0xFF1A110C)
        rank == 6 -> Color(0xFF0D1A10)
        else -> Color(0xFF0A0A0A)
    }
}
