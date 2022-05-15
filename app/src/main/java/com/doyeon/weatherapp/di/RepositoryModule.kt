package com.doyeon.weatherapp.di

import com.doyeon.weatherapp.data.repository.WeatherRepositoryImpl
import com.doyeon.weatherapp.data.source.WeatherDataSource
import com.doyeon.weatherapp.data.source.WeatherDataSourceImpl
import com.doyeon.weatherapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(weatherRepository: WeatherRepositoryImpl): WeatherRepository
}

