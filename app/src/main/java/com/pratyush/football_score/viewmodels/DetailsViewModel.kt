package com.pratyush.football_score.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pratyush.football_score.data.repo.FootRepo
import com.pratyush.football_score.data.utils.DetailsUiState
import com.pratyush.football_score.data.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: FootRepo,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val teamName: String =
        savedStateHandle["teamName"] ?: ""

    var uiState by mutableStateOf<DetailsUiState>(DetailsUiState.Loading)
        private set

    init {
        loadTeam()
    }

    private fun loadTeam() {
        viewModelScope.launch {
            when (val result = repository.getLaLigaStandings()) {
                is UiState.Success -> {
                    val team = result.data.find {
                        it.team.name == teamName
                    }
                    uiState = if (team != null)
                        DetailsUiState.Success(team)
                    else
                        DetailsUiState.Error("Team not found")
                }
                is UiState.Error -> {
                    uiState = DetailsUiState.Error(result.message)
                }
                else -> Unit
            }
        }
    }
}
