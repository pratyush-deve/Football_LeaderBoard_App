package com.pratyush.football_score.data.utils

import androidx.compose.ui.graphics.Color

fun DetailsCardColor(rank: Int): Color {
    return when {
        rank == 1 -> Color(0xFF3A2F0B)
        rank in 2..4 -> Color(0xFF0F2E4D)
        rank == 5 -> Color(0xFF3A1F0E)
        rank == 6 -> Color(0xFF0B3A18)
        else -> Color(0xFF1E2130)
    }
}
