package io.vetta.weatherapp.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import io.vetta.weatherapp.R
import io.vetta.weatherapp.models.WeatherResponse
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), WeatherContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter = WeatherPresenter(this, WeatherRepository())
        presenter.getWeather()
    }

    override fun weatherObtained(weatherResponse: WeatherResponse) {
        coordText.text = "las coordenadas son \n ${weatherResponse.coord?.lat} ${weatherResponse.coord?.lon}"
        weatherResponse.weather?.forEach {
                Log.i("MainActivity", "desc: ${it.description}")
        }
    }

    override fun showError(error: String) {
        Toast.makeText(applicationContext, error, Toast.LENGTH_LONG).show()
    }

    override fun showLoader(show: Boolean) {
        if (show) progressBar.visibility = View.VISIBLE
        else progressBar.visibility = View.GONE
    }
}
