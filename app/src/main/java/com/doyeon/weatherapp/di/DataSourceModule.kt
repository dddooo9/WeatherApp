package com.doyeon.weatherapp.di

import com.doyeon.weatherapp.data.source.WeatherDataSource
import com.doyeon.weatherapp.data.source.WeatherDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindWeatherDataSource(weatherDataSource: WeatherDataSourceImpl): WeatherDataSource
}
