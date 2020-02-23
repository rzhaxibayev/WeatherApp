package kz.rauanzk.weatherapp.ui.history

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_weather.view.*
import kz.rauanzk.weatherapp.R
import kz.rauanzk.weatherapp.data.entity.CurrentWeatherData
import kz.rauanzk.weatherapp.utils.format

class WeathersAdapter :
    RecyclerView.Adapter<WeathersAdapter.WeatherViewHolder>() {

    private var weathers = emptyList<CurrentWeatherData>()

    var onItemClickCallback: ((CurrentWeatherData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_weather, parent, false)
        )
    }

    override fun getItemCount(): Int = weathers.size

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(weathers[position], onItemClickCallback)
    }

    fun setOnItemClick(callback: (CurrentWeatherData) -> Unit) {
        onItemClickCallback = callback
    }

    fun update(items: List<CurrentWeatherData>) {
        weathers = items
        notifyDataSetChanged()
    }

    class WeatherViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        @SuppressLint("SetTextI18n")
        fun bind(weatherData: CurrentWeatherData, callback: ((CurrentWeatherData) -> Unit)?) {
            view.tvCity.text = "${weatherData.name}"
            view.tvDate.text = "Time: ${weatherData.time.format()}"
            view.tvTemperature.text = "Temperature: ${weatherData.main?.temperature}K"
            view.layoutWeatherItem.setOnClickListener {
                callback?.invoke(weatherData)
            }
        }
    }
}