package io.vetta.weatherapp.weather

import io.vetta.weatherapp.models.WeatherResponse

class WeatherPresenter (
    private val view: WeatherContract.View,
    private val repo: WeatherRepository
) : WeatherContract.Presenter {

    override fun getWeather() {
        view.showLoader(true)
        repo.getWeather(object : WeatherDataSource.GetWeatherCallback {
            override fun success(weatherResponse: WeatherResponse) {
                view.weatherObtained(weatherResponse)
                view.showLoader(false)
            }

            override fun error(error: String) {
                view.showLoader(false)
            }
        })
    }
}