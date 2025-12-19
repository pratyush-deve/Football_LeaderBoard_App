package com.pratyush.football_score.view.components

import android.R.attr.fontWeight
import android.R.attr.text
import android.R.attr.thickness
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun StandingsCard(
    teamName: String,
    logoUrl: String,
    abbreviation: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp, horizontal = 16.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Spacer(modifier = Modifier.width(12.dp))

            AsyncImage(
                model = logoUrl,
                contentDescription = teamName,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(12.dp))

            VerticalDivider(
                modifier = Modifier
                    .height(60.dp)
                    .padding(horizontal = 2.dp)
                    .width(2.dp),
                thickness = 2.dp,
                color = Color.Black
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
                ){
                    Text(
                        text = teamName,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Text(
                        text = abbreviation,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Light
                    )
                }
            }
        }
    }
}
