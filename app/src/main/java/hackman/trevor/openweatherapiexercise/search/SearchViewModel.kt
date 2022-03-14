package hackman.trevor.openweatherapiexercise.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hackman.trevor.openweatherapiexercise.util.onFailure
import hackman.trevor.openweatherapiexercise.util.onSuccess
import hackman.trevor.openweatherapiexercise.service.SearchFailure
import hackman.trevor.openweatherapiexercise.service.SearchResult
import hackman.trevor.openweatherapiexercise.service.ServiceFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchViewModel : ViewModel() {

    private val _searchResult = MutableLiveData<SearchResult?>()
    val searchResult: LiveData<SearchResult?> = _searchResult

    private val _searchError = MutableLiveData<String?>()
    val searchError: LiveData<String?> = _searchError

    fun search(query: String) {
        Log.d(TAG, "Searching for $query")
        ServiceFactory.openWeatherService.search(cityName = query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .onSuccess {
                Log.d(TAG, "Success $it")
                SearchData.searchResult = it
                _searchResult.value = it
                _searchResult.value = null
            }
            .onFailure<SearchResult, SearchFailure> {
                Log.e(TAG, "Failure $it")
                _searchError.value = it?.message ?: "ERROR"
                _searchError.value = null
            }
    }

    companion object {
        private const val TAG = "Search"
    }
}
