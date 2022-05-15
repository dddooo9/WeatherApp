package com.doyeon.weatherapp.data.source

import com.doyeon.weatherapp.data.model.WeatherAllData
import com.doyeon.weatherapp.data.model.WeatherSearchAllData

interface WeatherDataSource {

    suspend fun getLocation(): Result<WeatherSearchAllData>

    suspend fun getWeatherWithLocation(woeid: Int): Result<WeatherAllData>
}
