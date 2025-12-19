package com.pratyush.football_score.viewmodels

import HomeScreenState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pratyush.football_score.data.repo.FootRepo
import com.pratyush.football_score.data.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: FootRepo
) : ViewModel() {

    var screenState by mutableStateOf<HomeScreenState>(HomeScreenState.Loading)
        private set

    init {
        load()
    }

    private fun load() {
        viewModelScope.launch {
            when (val result = repository.getLaLigaStandings()) {

                is UiState.Success -> {
                    screenState = HomeScreenState.Success(result.data)
                }
                is UiState.Error -> {
                    screenState = HomeScreenState.Error(result.message)
                }
                else -> {
                    screenState = HomeScreenState.Loading
                }
            }
        }
    }
}
