package io.vetta.weatherapp.weather

import io.vetta.weatherapp.models.WeatherResponse

interface WeatherContract  {
    interface View {
        fun weatherObtained(weatherResponse: WeatherResponse)
        fun showLoader(show: Boolean)
        fun showError(error: String)
    }

    interface Presenter {
        fun getWeather()
    }
}