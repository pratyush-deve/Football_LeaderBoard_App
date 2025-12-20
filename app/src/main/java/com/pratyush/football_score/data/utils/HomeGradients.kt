package com.pratyush.football_score.data.utils

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

object HomeGradients {

    fun byRank(rank: Int): Brush {
        return when {
            rank == 1 -> Gold
            rank in 2..4 -> Blue
            rank == 5 -> Orange
            rank == 6 -> Green
            else -> Default
        }
    }

    private val Gold = Brush.horizontalGradient(
        listOf(
            Color(0xFFE6A800),
            Color(0xFFFFC83D),
        )
    )

    private val Blue = Brush.horizontalGradient(
        listOf(
            Color(0xFF1C6FD5),
            Color(0xFF3FA9F5),
        )
    )

    private val Orange = Brush.horizontalGradient(
        listOf(
            Color(0xFFFF6A00),
            Color(0xFFFF9A3C),
        )
    )

    private val Green = Brush.horizontalGradient(
        listOf(
            Color(0xFF11998E),
            Color(0xFF38EF7D),
        )
    )

    private val Default = Brush.horizontalGradient(
        listOf(
            Color(0xFF2A2E41),
            Color(0xFF3A3F58),
        )
    )
}
