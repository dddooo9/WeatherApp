package com.doyeon.weatherapp.domain.model

import com.doyeon.weatherapp.data.model.WeatherData

data class LocalWeather(
    val local: String,
    val today: WeatherData,
    val tomorrow: WeatherData
)
