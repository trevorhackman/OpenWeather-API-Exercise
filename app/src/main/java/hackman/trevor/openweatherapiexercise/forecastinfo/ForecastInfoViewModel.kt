package hackman.trevor.openweatherapiexercise.forecastinfo

import androidx.lifecycle.ViewModel
import hackman.trevor.openweatherapiexercise.search.SearchData
import hackman.trevor.openweatherapiexercise.searchresults.SearchResultsData
import hackman.trevor.openweatherapiexercise.util.formatFeelsLike
import hackman.trevor.openweatherapiexercise.util.formatTemperature
import hackman.trevor.openweatherapiexercise.util.formatTime

class ForecastInfoViewModel : ViewModel() {

    private val forecast get() = SearchResultsData.forecastClicked

    val cityName: String? get() = SearchData.searchResult?.city?.name

    val time: String? get() = forecast?.formatTime()

    val temperature: String? get() = forecast?.formatTemperature()

    val feelsLike: String? get() = forecast?.formatFeelsLike()

    val weather: String? get() = forecast?.weather?.firstOrNull()?.main

    val weatherDescription: String? get() = forecast?.weather?.firstOrNull()?.description
}
