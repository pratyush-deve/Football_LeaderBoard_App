package com.pratyush.football_score.data.repo

import com.pratyush.football_score.data.model.StandingsResponseItem
import com.pratyush.football_score.data.remote.FootApi
import com.pratyush.football_score.data.utils.UiState
import javax.inject.Inject

class FootRepo @Inject constructor(private val api: FootApi) {

    suspend fun getLaLigaStandings() : UiState<List<StandingsResponseItem>>{
        return try {
            val response = api.getLaLigaStandings()
            UiState.Success(response)
        } catch (e: Exception) {
            UiState.Error(e.message ?: "Something went wrong")
        }
    }

}