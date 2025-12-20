package com.pratyush.football_score.data.remote

import com.pratyush.football_score.data.model.StandingsResponseItem
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface FootApi {

    @Headers(
        "x-rapidapi-key: 100c853a0dmsh006c16e8ad3daeap104623jsnc5a6bf601cc5",
        "x-rapidapi-host: laliga-standings.p.rapidapi.com"
    )
    @GET("/")
    suspend fun getLaLigaStandings(): List<StandingsResponseItem>
}
