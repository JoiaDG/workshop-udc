package io.vetta.weatherapp.api

import io.vetta.weatherapp.models.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    /**
     * Change apiKey value with your own openweathermap.org api key
     */
    @GET("weather")
    fun getWeatherByCity(
        @Query("q") city: String,
        @Query("APPID") apiKey: String = "<your api key>") : Call<WeatherResponse>

}