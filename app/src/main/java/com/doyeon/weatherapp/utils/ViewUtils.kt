package com.doyeon.weatherapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("weatherType")
fun setWeatherImage(view: ImageView, type: String) {
    Glide.with(view.context)
        .load("https://www.metaweather.com/static/img/weather/png/$type.png")
        .into(view)
}
