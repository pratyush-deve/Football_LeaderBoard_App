package com.pratyush.football_score.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pratyush.football_score.data.model.StandingsResponseItem
import com.pratyush.football_score.data.repo.FootRepo
import com.pratyush.football_score.data.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val repository: FootRepo
): ViewModel(){

    var standingsState by mutableStateOf<UiState<List<StandingsResponseItem>>>(UiState.Loading)
        private set

    fun getLaLigaStandings() {
        viewModelScope.launch {
            standingsState = UiState.Loading
            standingsState = repository.getLaLigaStandings()
        }
    }
}