package io.vetta.weatherapp.weather

import io.vetta.weatherapp.models.WeatherResponse

interface WeatherDataSource {

    interface GetWeatherCallback {
        fun success(weatherResponse: WeatherResponse)
        fun error(error: String)
    }

    fun getWeather(callback: GetWeatherCallback)
}