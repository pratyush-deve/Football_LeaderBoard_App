package com.pratyush.football_score.data.repo

import android.util.Log
import com.pratyush.football_score.data.model.StandingsResponseItem
import com.pratyush.football_score.data.remote.FootApi
import com.pratyush.football_score.data.utils.UiState
import javax.inject.Inject

class FootRepo @Inject constructor(private val api: FootApi) {

    suspend fun getLaLigaStandings() : UiState<List<StandingsResponseItem>>{
        return try {
            val response = api.getLaLigaStandings()
            Log.d("API_CHECK", "Size = ${response.size}")
            UiState.Success(response)
        } catch (e: Exception) {
            Log.e("API_CHECK", "Error", e)
            UiState.Error(e.message ?: "Something went wrong")
        }
    }

}