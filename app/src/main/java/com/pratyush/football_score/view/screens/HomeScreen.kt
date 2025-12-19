package com.pratyush.football_score.view.screens

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.pratyush.football_score.data.utils.UiState
import com.pratyush.football_score.viewmodels.StandingsViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun HomeScreen(
    viewModel: StandingsViewModel  = hiltViewModel()
){
    LaunchedEffect(Unit) {
        viewModel.getLaLigaStandings()
    }

    when(
        val state = viewModel.standingsState
    ) {
        is UiState.Loading -> {
            CircularProgressIndicator()
        }
        is UiState.Success -> {
            Text(text = state.data[1].team.name)
        }
        is UiState.Error -> {
            Text(text = state.message)
        }
        else -> {
            TODO()
        }
    }
}