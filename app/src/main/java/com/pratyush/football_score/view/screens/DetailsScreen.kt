package com.pratyush.football_score.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.pratyush.football_score.data.utils.DetailGradients
import com.pratyush.football_score.data.utils.DetailsBgColor
import com.pratyush.football_score.data.utils.DetailsCardColor
import com.pratyush.football_score.data.utils.DetailsScreenLogoBorder
import com.pratyush.football_score.data.utils.DetailsUiState
import com.pratyush.football_score.view.components.DetailsStatCard
import com.pratyush.football_score.viewmodels.DetailsViewModel
import com.pratyush.football_score.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    onBack: () -> Unit,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    val state = viewModel.uiState

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Details Screen",
                            color = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2A2E41)
                ),
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(
                    color = Color(0xFF000000)
                )
        ) {
            when (state) {

                is DetailsUiState.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(color = Color.White)
                    }
                }

                is DetailsUiState.Error -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = state.message,
                            color = Color.White
                        )
                    }
                }

                is DetailsUiState.Success -> {
                    val team = state.team

                    DetailsContent(
                        teamName = team.team.name,
                        abbreviation = team.team.abbreviation,
                        rank = team.stats.rank,
                        points = team.stats.points,
                        gamesPlayed = team.stats.gamesPlayed,
                        logoUrl = team.team.logo,
                        wins = team.stats.wins,
                        loses = team.stats.losses,
                        draws = team.stats.ties,
                        goalsFor = team.stats.goalsFor,
                        goalsAgainst = team.stats.goalsAgainst,
                        goalDifference = team.stats.goalDifference
                    )
                }
            }
        }
    }
}
@Composable
private fun DetailsContent(
    teamName: String,
    abbreviation: String,
    rank: Int,
    points: Int,
    gamesPlayed: Int,
    logoUrl : String,
    wins : Int,
    loses : Int,
    draws : Int,
    goalsFor : Int,
    goalsAgainst : Int,
    goalDifference : Int
) {

    val borderColor = DetailsScreenLogoBorder(rank = rank)
    val scrollState = rememberScrollState()
    val columnColor = DetailsBgColor(rank = rank)
    val cardColors = DetailsCardColor(rank = rank)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        columnColor,
                        Color.Black
                    )
                )
            )
            .verticalScroll(scrollState)
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(vertical = 8.dp, horizontal = 16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = cardColors
                    )
                    .border(
                        width = 4.dp,
                        color = borderColor,
                        shape = RoundedCornerShape(16.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = logoUrl,
                    contentDescription = teamName,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(
                    color = cardColors
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = teamName,
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = abbreviation,
                    color = Color.LightGray,
                    fontSize = 15.sp
                )
            }
        }
        DetailsStatCard(
            label = "Rank",
            value = "#$rank",
            iconRes = R.drawable.rank,
            gradient = DetailGradients.Rank
        )

        DetailsStatCard(
            label = "Points",
            value = "$points",
            iconRes = R.drawable.points,
            gradient = DetailGradients.Points
        )

        DetailsStatCard(
            label = "Wins",
            value = "$wins",
            iconRes = R.drawable.wins,
            gradient = DetailGradients.Wins
        )

        DetailsStatCard(
            label = "Losses",
            value = "$loses",
            iconRes = R.drawable.loses,
            gradient = DetailGradients.Losses
        )

        DetailsStatCard(
            label = "Draws",
            value = "$draws",
            iconRes = R.drawable.draws,
            gradient = DetailGradients.Draws
        )


    }
}



