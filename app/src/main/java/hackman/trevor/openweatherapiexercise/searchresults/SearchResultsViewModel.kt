package hackman.trevor.openweatherapiexercise.searchresults

import androidx.lifecycle.ViewModel
import hackman.trevor.openweatherapiexercise.search.SearchData
import hackman.trevor.openweatherapiexercise.service.Forecast

class SearchResultsViewModel : ViewModel() {

    val cityName: String? get() = SearchData.searchResult?.city?.name
    val forecasts: List<Forecast>? get() = SearchData.searchResult?.list

    fun forecastClicked(forecast: Forecast) {
        SearchResultsData.forecastClicked = forecast
    }

}
