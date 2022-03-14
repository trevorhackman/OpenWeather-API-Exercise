package com.example.openweatherapiexercise.util

import com.example.openweatherapiexercise.service.Forecast
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

fun Forecast.formatTime(): String {
    return SimpleDateFormat("EEEE h:mm a", Locale.US).run {
        val milliseconds = TimeUnit.SECONDS.toMillis(dt.toLong())
        format(milliseconds)
    }
}

fun Forecast.formatTemperature(): String {
    return main.temp.kelvinToFahrenheit().toInt().toString()
}

fun Forecast.formatFeelsLike(): String {
    return main.feels_like.kelvinToFahrenheit().toInt().toString()
}

private fun Double.kelvinToFahrenheit() = 1.8 * (this - 273) + 32
