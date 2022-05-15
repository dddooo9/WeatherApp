package com.doyeon.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.doyeon.weatherapp.domain.model.LocalWeather
import com.doyeon.weatherapp.databinding.ItemWeatherBinding
import com.doyeon.weatherapp.databinding.ItemWeatherTitleBinding

class WeatherAdapter : ListAdapter<LocalWeather, RecyclerView.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HEADER_VIEW_TYPE -> WeatherHeaderViewHolder(
                ItemWeatherTitleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> WeatherViewHolder(
                ItemWeatherBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position != 0) (holder as WeatherViewHolder).bind(currentList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> HEADER_VIEW_TYPE
            else -> ITEM_VIEW_TYPE
        }
    }

    class WeatherHeaderViewHolder(
        private val binding: ItemWeatherTitleBinding
    ) : RecyclerView.ViewHolder(binding.root)

    class WeatherViewHolder(
        private val binding: ItemWeatherBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(localWeather: LocalWeather) {
            binding.weatherData = localWeather
            binding.executePendingBindings()
        }
    }

    companion object {
        const val HEADER_VIEW_TYPE = 0
        const val ITEM_VIEW_TYPE = 1

        val diffUtil = object : DiffUtil.ItemCallback<LocalWeather>() {
            override fun areItemsTheSame(
                oldItem: LocalWeather,
                newItem: LocalWeather
            ): Boolean {
                return oldItem.local == newItem.local
            }

            override fun areContentsTheSame(
                oldItem: LocalWeather,
                newItem: LocalWeather
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
