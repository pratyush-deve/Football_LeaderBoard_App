package com.pratyush.football_score.data.utils

import androidx.compose.ui.graphics.Color

fun CardColorRank(rank: Int): Color {
    return when {
        rank == 1 -> Color(0xFFFFBF00)
        rank in 2..4 -> Color(0xFF1989E1)
        rank == 5 -> Color(0xFFFF7A22)
        rank == 6 -> Color(0xFF0AEE13)
        else -> Color(0xFF2A2E41)
    }
}

