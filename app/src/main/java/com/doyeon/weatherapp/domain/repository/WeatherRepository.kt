package com.doyeon.weatherapp.domain.repository

import com.doyeon.weatherapp.data.model.WeatherAllData
import com.doyeon.weatherapp.data.model.WeatherSearchAllData

interface WeatherRepository {

    suspend fun getLocation(): Result<WeatherSearchAllData>

    suspend fun getWeatherWithLocation(woeid: Int): Result<WeatherAllData>
}
