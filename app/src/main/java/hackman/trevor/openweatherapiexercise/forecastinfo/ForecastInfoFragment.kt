package hackman.trevor.openweatherapiexercise.forecastinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import hackman.trevor.openweatherapiexercise.R
import hackman.trevor.openweatherapiexercise.databinding.ForecastInfoFragmentBinding

class ForecastInfoFragment : Fragment() {

    private val forecastInfoViewModel: ForecastInfoViewModel by viewModels()

    private var _binding: ForecastInfoFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = ForecastInfoFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindBackButton()
        bindCityName()
        bindTime()
        bindTemperature()
        bindFeelsLike()
        bindWeather()
        bindWeatherDescription()
    }

    private fun bindBackButton() {
        binding.forecastInfoTopBar.topBarBackButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    private fun bindCityName() {
        binding.forecastInfoTopBar.topBarCityName.text = forecastInfoViewModel.cityName
    }

    private fun bindTime() {
        binding.forecastInfoTime.text = forecastInfoViewModel.time
    }

    private fun bindTemperature() {
        binding.forecastInfoTemperature.text = forecastInfoViewModel.temperature
    }

    private fun bindFeelsLike() {
        binding.forecastInfoFeelsLike.text = getString(R.string.feels_like_colon, forecastInfoViewModel.feelsLike)
    }

    private fun bindWeather() {
        binding.forecastInfoWeather.text = forecastInfoViewModel.weather
    }

    private fun bindWeatherDescription() {
        binding.forecastInfoWeatherDescription.text = forecastInfoViewModel.weatherDescription
    }
}
