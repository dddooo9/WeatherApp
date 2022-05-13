package com.doyeon.weatherapp.data.api

import com.doyeon.weatherapp.data.model.WeatherAllData
import com.doyeon.weatherapp.data.model.WeatherSearchAllData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {

    @GET("location/search/")
    suspend fun getLocation(
        @Query("query") query: String = "se"
    ): Response<WeatherSearchAllData>

    @GET("location/{woeid}")
    suspend fun getWeatherWithLocation(
        @Path("woeid") woeid: Int
    ): Response<WeatherAllData>
}
