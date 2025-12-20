package com.pratyush.football_score.view.screens

import HomeScreenState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pratyush.football_score.view.components.StandingsCard
import com.pratyush.football_score.viewmodels.HomeScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    onTeamClick: (String)->Unit
) {
    val state = viewModel.screenState

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "La Liga Standings",
                            color = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2A2E41)
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(
                    Color(0xFF000000)
                )
        ) {
            HomeScreenContent(
                state,
                onTeamClick = onTeamClick
            )
        }
    }
}

@Composable
private fun HomeScreenContent(
    state: HomeScreenState,
    onTeamClick: (String) -> Unit = {}
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        when (state) {

            is HomeScreenState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            is HomeScreenState.Success -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    items(
                        items = state.items.take(20),
                        key = { it.team.name }
                    ) { item ->
                        StandingsCard(
                            teamName = item.team.name,
                            logoUrl = item.team.logo,
                            abbreviation = item.team.abbreviation,
                            gamesplayed = item.stats.gamesPlayed,
                            goaldiff = item.stats.goalDifference,
                            points = item.stats.points,
                            rank = item.stats.rank,
                            onClick = {
                                onTeamClick(item.team.name)
                            }
                        )
                    }
                }
            }
            is HomeScreenState.Error -> {
                Text(
                    text = state.message,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}