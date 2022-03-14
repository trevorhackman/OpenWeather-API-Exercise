package com.example.openweatherapiexercise.forecastinfo

import androidx.lifecycle.ViewModel
import com.example.openweatherapiexercise.search.SearchData
import com.example.openweatherapiexercise.searchresults.SearchResultsData
import com.example.openweatherapiexercise.util.formatFeelsLike
import com.example.openweatherapiexercise.util.formatTemperature
import com.example.openweatherapiexercise.util.formatTime

class ForecastInfoViewModel : ViewModel() {

    private val forecast get() = SearchResultsData.forecastClicked

    val cityName: String? get() = SearchData.searchResult?.city?.name

    val time: String? get() = forecast?.formatTime()

    val temperature: String? get() = forecast?.formatTemperature()

    val feelsLike: String? get() = forecast?.formatFeelsLike()

    val weather: String? get() = forecast?.weather?.firstOrNull()?.main

    val weatherDescription: String? get() = forecast?.weather?.firstOrNull()?.description
}
