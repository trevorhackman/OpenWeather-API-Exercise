package com.example.openweatherapiexercise.searchresults

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.openweatherapiexercise.R
import com.example.openweatherapiexercise.databinding.SearchResultsFragmentBinding
import com.example.openweatherapiexercise.forecastinfo.ForecastInfoFragment
import com.example.openweatherapiexercise.service.Forecast

class SearchResultsFragment : Fragment() {

    private val searchResultsViewModel: SearchResultsViewModel by viewModels()

    private var _binding: SearchResultsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = SearchResultsFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindBackButton()
        bindCityName()
        bindForecastList()
    }

    private fun bindBackButton() {
        binding.searchResultsTopBar.topBarBackButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    private fun bindCityName() {
        binding.searchResultsTopBar.topBarCityName.text = searchResultsViewModel.cityName
    }

    private fun bindForecastList() {
        val forecasts = searchResultsViewModel.forecasts ?: return
        binding.searchResultsList.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = ForecastListAdapter(forecasts) { onForecastClicked(it) }
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }

    private fun onForecastClicked(forecast: Forecast) {
        searchResultsViewModel.forecastClicked(forecast)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ForecastInfoFragment())
            .addToBackStack(null)
            .commit()
    }
}
