package io.vetta.weatherapp.api

import io.vetta.weatherapp.models.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("weather")
    fun getWeatherByCity(
        @Query("q") city: String,
        @Query("APPID") apiKey: String = "cfe738f6f981649b6c30fee2dee8e1ce") : Call<WeatherResponse>

}