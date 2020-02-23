package kz.rauanzk.weatherapp.ui.main

import kz.rauanzk.weatherapp.data.repository.WeatherRepository
import kz.rauanzk.weatherapp.ui.base.BaseViewModel
import timber.log.Timber

class MainActivityViewModel(
    private val weatherRepository: WeatherRepository
) : BaseViewModel() {

    init {
        Timber.d("MainActivityViewModel")
    }
}