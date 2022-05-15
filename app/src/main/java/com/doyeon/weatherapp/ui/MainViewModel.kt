package com.doyeon.weatherapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doyeon.weatherapp.data.model.WeatherSearchData
import com.doyeon.weatherapp.domain.model.LocalWeather
import com.doyeon.weatherapp.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _weatherData = MutableLiveData<List<LocalWeather>>()
    val localWeather: LiveData<List<LocalWeather>> = _weatherData

    fun searchWeather() {
        viewModelScope.launch {
            weatherRepository.getLocation()
                .onSuccess { locations ->
                    _weatherData.value = locations.mapNotNull { getWeatherWithLocation(it) }
                }
                .onFailure {
                    Log.e(this.javaClass.name, it.message ?: "search error")
                }
        }
    }

    private suspend fun getWeatherWithLocation(searchData: WeatherSearchData): LocalWeather? {
        weatherRepository.getWeatherWithLocation(searchData.woeid)
            .onSuccess {
                val todayAndTomorrowWeatherData = it.weekData.subList(0, 2)

                return LocalWeather(
                    local = searchData.title,
                    today = todayAndTomorrowWeatherData[0],
                    tomorrow = todayAndTomorrowWeatherData[1]
                )
            }.onFailure {
                Log.e(this.javaClass.name, it.message ?: "weather error")
                return null
            }

        return null
    }
}
