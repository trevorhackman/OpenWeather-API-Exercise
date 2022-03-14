package com.example.openweatherapiexercise.searchresults

import androidx.lifecycle.ViewModel
import com.example.openweatherapiexercise.search.SearchData
import com.example.openweatherapiexercise.service.Forecast

class SearchResultsViewModel : ViewModel() {

    val cityName: String? get() = SearchData.searchResult?.city?.name
    val forecasts: List<Forecast>? get() = SearchData.searchResult?.list

    fun forecastClicked(forecast: Forecast) {
        SearchResultsData.forecastClicked = forecast
    }

}
