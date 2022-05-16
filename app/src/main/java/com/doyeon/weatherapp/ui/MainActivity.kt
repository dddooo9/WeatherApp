package com.doyeon.weatherapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.doyeon.weatherapp.R
import com.doyeon.weatherapp.databinding.ActivityMainBinding
import com.doyeon.weatherapp.domain.model.LocalWeather
import com.doyeon.weatherapp.ui.adapter.WeatherAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var weatherAdapter: WeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initView()
    }

    private fun initView() {
        setWeatherAdapter()
        setObserver()

        viewModel.searchWeather()
    }

    private fun setWeatherAdapter() {
        weatherAdapter = WeatherAdapter()
        binding.rvMainWeather.adapter = weatherAdapter
    }

    private fun setObserver() {
        viewModel.localWeather.observe(this) {
            val dataForAddHeader: MutableList<LocalWeather?> = it.toMutableList()
            dataForAddHeader.add(0, null)

            weatherAdapter.submitList(dataForAddHeader)
            invisibleProgressBar()
        }
    }

    private fun invisibleProgressBar() {
        binding.pbMainWeather.isVisible = false
    }
}
