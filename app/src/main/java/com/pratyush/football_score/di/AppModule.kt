package com.pratyush.football_score.di

import com.pratyush.football_score.data.remote.FootApi
import com.pratyush.football_score.data.repo.FootRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.jvm.java


private const val BASE_URL = "https://laliga-standings.p.rapidapi.com/"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePokemonRepository(
        api: FootApi
    ) = FootRepo(api)

    @Singleton
    @Provides
    fun providePokeApi(): FootApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(FootApi::class.java)
    }
}