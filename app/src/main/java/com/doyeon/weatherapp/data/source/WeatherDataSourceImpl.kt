package com.doyeon.weatherapp.data.source

import com.doyeon.weatherapp.data.api.WeatherService
import com.doyeon.weatherapp.data.model.WeatherAllData
import com.doyeon.weatherapp.data.model.WeatherSearchAllData
import java.lang.Exception
import javax.inject.Inject

class WeatherDataSourceImpl @Inject constructor(
    private val weatherService: WeatherService
) : WeatherDataSource {

    override suspend fun getLocation(): Result<WeatherSearchAllData> {
        return try {
            val data = weatherService.getLocation()
            if (data.isSuccessful) {
                data.body()?.let { Result.success(it) } ?: Result.failure(Throwable(data.message()))
            } else {
                Result.failure(Throwable(data.message()))
            }
        } catch (e: Exception) {
            Result.failure(Throwable(e.message))
        }
    }

    override suspend fun getWeatherWithLocation(woeid: Int): Result<WeatherAllData> {
        return try {
            val data = weatherService.getWeatherWithLocation(woeid)
            if (data.isSuccessful) {
                data.body()?.let { Result.success(it) } ?: Result.failure(Throwable(data.message()))
            } else {
                Result.failure(Throwable(data.message()))
            }
        } catch (e: Exception) {
            Result.failure(Throwable(e.message))
        }
    }
}
