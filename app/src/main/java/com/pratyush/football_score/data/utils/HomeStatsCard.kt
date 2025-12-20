package com.pratyush.football_score.data.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RowScope.StatsCard(
    text: String,
    number: Int,
    textColor: Color,
    accentColor: Color
    //An accent color is a highlight color used to
    // draw attention to the most important part of a UI element.
) {
    Box(
        modifier = Modifier
            .weight(1f)
            .height(56.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(
                Color.White.copy(alpha = 0.18f)
            )
            .border(
                width = 1.dp,
                color = Color.White.copy(alpha = 0.35f),
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.White.copy(alpha = 0.25f),
                            Color.Transparent
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 6.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = text,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = textColor.copy(alpha = 0.85f)
            )

            Text(
                text = number.toString(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = accentColor
            )
        }
    }
}
@Composable
fun StatsRow(
    played: Int,
    goalDiff: Int,
    points: Int,
    textColor: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        StatsCard(
            text = "PL",//Played
            number = played,
            textColor = textColor,
            accentColor = Color.White
        )
        StatsCard(
            text = "GD",//Goal Diff
            number = goalDiff,
            textColor = textColor,
            accentColor = if (goalDiff >= 0)
                Color(0xFF00FF90)
            else
                Color(0xFFFD3A3A)
        )
        StatsCard(
            text = "PTS",//Points
            number = points,
            textColor = textColor,
            accentColor = Color(0xFF000000)
        )
    }
}

