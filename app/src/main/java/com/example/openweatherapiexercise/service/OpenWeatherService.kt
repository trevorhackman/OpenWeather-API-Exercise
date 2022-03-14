package com.example.openweatherapiexercise.service

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherService {

    @GET("data/2.5/forecast")
    fun search(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String = API_KEY
    ): Single<Response<SearchResult>>

    companion object {
        private const val API_KEY = "65d00499677e59496ca2f318eb68c049" // This should be hidden
    }
}
