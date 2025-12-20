package com.pratyush.football_score.data.utils

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pratyush.football_score.data.model.Team

@Composable
fun StatsCard(
    text: String,
    number: Int,
    textColor : Color,
    cardColor: Color
){
    Card(
        modifier = Modifier
            .width(90.dp)
            .height(55.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardColor
        ),
        elevation = CardDefaults.cardElevation(
            hoveredElevation = 10.dp
        ),
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        ){
            Text(
                text = "$text",
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp,
                color = textColor
            )
            Text(
                text = "$number",
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                color = textColor
            )
        }
    }
}
@Composable
fun StatsRow(
    played: Int,
    goalDiff: Int,
    points: Int,
    textcolor: Color,
    cardColor: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        StatsCard("Played", played, textcolor,cardColor)
        StatsCard("Goal Diff", goalDiff, textcolor,cardColor)
        StatsCard("Points", points, textcolor,cardColor)
    }
}

