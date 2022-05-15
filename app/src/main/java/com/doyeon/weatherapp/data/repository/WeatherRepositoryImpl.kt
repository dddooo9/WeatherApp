package com.doyeon.weatherapp.data.repository

import com.doyeon.weatherapp.data.model.WeatherAllData
import com.doyeon.weatherapp.data.model.WeatherSearchAllData
import com.doyeon.weatherapp.data.source.WeatherDataSource
import com.doyeon.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val dataSource: WeatherDataSource
) : WeatherRepository {
    override suspend fun getLocation(): Result<WeatherSearchAllData> {
        val result = dataSource.getLocation()

        return if (result.exceptionOrNull() is Exception) {
            Result.failure(result.exceptionOrNull() as Exception)
        } else {
            result
        }
    }

    override suspend fun getWeatherWithLocation(woeid: Int): Result<WeatherAllData> {
        val result = dataSource.getWeatherWithLocation(woeid)

        return if (result.exceptionOrNull() is Exception) {
            Result.failure(result.exceptionOrNull() as Exception)
        } else {
            result
        }
    }
}
