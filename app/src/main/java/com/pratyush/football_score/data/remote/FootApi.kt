package com.pratyush.football_score.data.remote

import com.pratyush.football_score.data.model.StandingsResponseItem
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface FootApi {

    @Headers(
        "x-rapidapi-key: 4226237bb9msh9dc42d685608170p177cc6jsn54db19933653",
        "x-rapidapi-host: laliga-standings.p.rapidapi.com"
    )
    @GET("/")
    suspend fun getLaLigaStandings(
        @Query("season") season: Int = 2022
    ): List<StandingsResponseItem>
}
