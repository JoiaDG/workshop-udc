package io.vetta.weatherapp.weather

import io.vetta.weatherapp.api.MyRetroditBuilder
import io.vetta.weatherapp.models.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository : WeatherDataSource {

    override fun getWeather(callback: WeatherDataSource.GetWeatherCallback) {
        val call = MyRetroditBuilder.apiService.getWeatherByCity("Colima")
        call.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.isSuccessful) {
                    callback.success(response.body() as WeatherResponse)
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                callback.error(t.localizedMessage)
            }
        })
    }
}