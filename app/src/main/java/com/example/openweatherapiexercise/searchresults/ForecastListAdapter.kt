package com.example.openweatherapiexercise.searchresults

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.openweatherapiexercise.R
import com.example.openweatherapiexercise.databinding.ForecastItemBinding
import com.example.openweatherapiexercise.service.Forecast
import com.example.openweatherapiexercise.util.formatTemperature
import com.example.openweatherapiexercise.util.formatTime

class ForecastListAdapter(
    private val forecasts: List<Forecast>,
    private val onForecastClicked: (Forecast) -> Unit
) : RecyclerView.Adapter<ForecastListAdapter.ForecastListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastListViewHolder {
        val binding = ForecastItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ForecastListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ForecastListViewHolder, position: Int) {
        holder.bind(forecasts[position], onForecastClicked)
    }

    override fun getItemCount(): Int = forecasts.size

    class ForecastListViewHolder(private val binding: ForecastItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var forecast: Forecast
        private lateinit var onForecastClicked: (Forecast) -> Unit

        init {
            setClickListener()
        }

        fun bind(forecast: Forecast, onForecastClicked: (Forecast) -> Unit) {
            this.forecast = forecast
            this.onForecastClicked = onForecastClicked
            binding.forecastItemTime.text = forecast.formatTime()
            binding.forecastItemWeather.text = forecast.weather.firstOrNull()?.main
            binding.forecastItemTemperature.text = itemView.context.getString(R.string.temp_colon, forecast.formatTemperature())
        }

        private fun setClickListener() {
            binding.root.setOnClickListener {
                onForecastClicked(forecast)
            }
        }
    }
}
