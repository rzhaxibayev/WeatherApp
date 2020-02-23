package kz.rauanzk.weatherapp.data.repository

import kz.rauanzk.weatherapp.BuildConfig
import kz.rauanzk.weatherapp.data.api.base.Result
import kz.rauanzk.weatherapp.data.api.ApiDataSource
import kz.rauanzk.weatherapp.data.db.WeatherDao
import kz.rauanzk.weatherapp.data.entity.CurrentWeatherData
import kz.rauanzk.weatherapp.data.repository.base.BaseRepository

class WeatherRepository(
    private val apiDataSource: ApiDataSource,
    private val weatherDao: WeatherDao
) : BaseRepository() {

    val weathers = weatherDao.fetchWeathers()

    fun insertWeather(weather: CurrentWeatherData) {
        weatherDao.insert(weather)
    }

    suspend fun fetchCurrentWeather(city: String): Result<CurrentWeatherData> {
        return safeApiCall {
            apiDataSource.fetchCurrentWeather(city, BuildConfig.appId)
        }
    }

    suspend fun fetchWeatherDetails(id: Long): Result<CurrentWeatherData> {
        return safeApiCall {
            apiDataSource.fetchWeatherDetails(id, BuildConfig.appId)
        }
    }
}