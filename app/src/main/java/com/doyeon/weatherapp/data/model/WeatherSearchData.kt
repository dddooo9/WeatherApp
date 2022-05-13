package com.doyeon.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class WeatherSearchData(
    @SerializedName("title") val title: String,
    @SerializedName("woeid") val woeid: Int
)
