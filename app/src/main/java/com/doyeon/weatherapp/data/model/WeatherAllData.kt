package com.doyeon.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class WeatherAllData(
    @SerializedName("consolidated_weather") val weekData: List<WeatherData>
)
