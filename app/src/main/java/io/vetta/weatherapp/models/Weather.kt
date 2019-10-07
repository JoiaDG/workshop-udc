package io.vetta.weatherapp.models

data class Weather(
    var id: Int? = null,
    var main: String? = null,
    var icon: String? = null,
    var description: String? = null
)