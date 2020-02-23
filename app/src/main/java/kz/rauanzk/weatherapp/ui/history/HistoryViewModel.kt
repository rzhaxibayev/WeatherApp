package kz.rauanzk.weatherapp.ui.history

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.rauanzk.weatherapp.data.entity.CurrentWeatherData
import kz.rauanzk.weatherapp.data.repository.WeatherRepository
import kz.rauanzk.weatherapp.ui.base.BaseViewModel
import kz.rauanzk.weatherapp.utils.Event
import timber.log.Timber
import java.util.*

class HistoryViewModel(
    private val weatherRepository: WeatherRepository
) : BaseViewModel() {

    init {
        Timber.d("HistoryViewModel")
    }

    val weathers = weatherRepository.weathers

    fun fetchCurrentWeather(city: String) {
        apiCall<CurrentWeatherData>(
            { weatherRepository.fetchCurrentWeather(city) },
            onSuccess = { currentWeatherData ->
                viewModelScope.launch {
                    currentWeatherData.time = Date().time
                    weatherRepository.insertWeather(currentWeatherData)
                }
            },
            onError = { message ->
                Timber.d("onError: message = $message")
                message?.let {
                    showToastEvent.value = Event(message)
                }
            },
            onComplete = {
                Timber.d("onComplete")
            }
        )
    }
}