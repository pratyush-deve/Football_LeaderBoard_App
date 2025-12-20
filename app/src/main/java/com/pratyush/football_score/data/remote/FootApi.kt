package com.pratyush.football_score.data.remote

import com.pratyush.football_score.data.model.StandingsResponseItem
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface FootApi {

    @Headers(
        "x-rapidapi-key: 32d45c8096msh5b6dc655b208721p15daffjsnf43c81f9486f",
        "x-rapidapi-host: laliga-standings.p.rapidapi.com"
    )
    @GET("/")
    suspend fun getLaLigaStandings(): List<StandingsResponseItem>
}

