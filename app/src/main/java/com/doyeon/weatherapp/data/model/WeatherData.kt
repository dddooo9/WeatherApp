package com.doyeon.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class WeatherData(
    @SerializedName("weather_state_name") val weatherName: String,
    @SerializedName("weather_state_abbr") val weatherSummary: String,
    @SerializedName("the_temp") val temperature: Int,
    @SerializedName("humidity") val humidity: Int,
)
