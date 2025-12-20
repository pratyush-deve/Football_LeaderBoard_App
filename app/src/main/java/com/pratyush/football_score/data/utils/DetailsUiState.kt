package com.pratyush.football_score.data.utils

import com.pratyush.football_score.data.model.StandingsResponseItem

sealed class DetailsUiState {
    object Loading : DetailsUiState()
    data class Success(val team: StandingsResponseItem) : DetailsUiState()
    data class Error(val message: String) : DetailsUiState()
}
