package kz.rauanzk.weatherapp.data.api

import kz.rauanzk.weatherapp.data.entity.CurrentWeatherData
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiDataSource {

    @POST("data/2.5/weather")
    suspend fun fetchCurrentWeather(@Query("q") city: String, @Query("appid") appId: String): Response<CurrentWeatherData>

    @POST("data/2.5/weather")
    suspend fun fetchWeatherDetails(@Query("id") id: Long, @Query("appid") appId: String): Response<CurrentWeatherData>
}