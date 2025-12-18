package com.pratyush.football_score.data.model

data class Stats(
    val gamesPlayed: Int,
    val goalDifference: Int,
    val goalsAgainst: Int,
    val goalsFor: Int,
    val losses: Int,
    val points: Int,
    val rank: Int,
    val ties: Int,
    val wins: Int
)