package io.vetta.weatherapp.models

data class WeatherResponse (
    var coord: Coord? = null,
    var weather: List<Weather>? = null
)