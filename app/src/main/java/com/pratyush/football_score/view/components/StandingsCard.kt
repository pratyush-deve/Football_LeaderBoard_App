package com.pratyush.football_score.view.components

import android.R.attr.contentDescription
import android.R.attr.fontWeight
import android.R.attr.text
import android.R.attr.thickness
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun StandingsCard(
    teamName: String,
    logoUrl: String,
    abbreviation: String,
    gamesplayed: Int
) {
    val textcolor = Color(0xFFFFFFFF)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp, horizontal = 16.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(color = 0xFF2A2E41)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Spacer(modifier = Modifier.width(8.dp))

            Card (
                modifier = Modifier
                    .padding(2.dp)
                    .size(70.dp),
                shape = RoundedCornerShape(8.dp)
            ){
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    AsyncImage(
                        model = logoUrl,
                        contentDescription = teamName,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            VerticalDivider(
                modifier = Modifier
                    .height(60.dp)
                    .padding(horizontal = 2.dp)
                    .width(2.dp),
                thickness = 2.dp,
                color = textcolor
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(1f)
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "$teamName ($abbreviation)",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = textcolor
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ){
                    Text(
                        text = "Played: $gamesplayed",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Light,
                        color = textcolor
                    )
                }
            }
            Spacer(modifier = Modifier.width(12.dp))
        }
    }
}
