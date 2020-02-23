package kz.rauanzk.weatherapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kz.rauanzk.weatherapp.data.entity.CurrentWeatherData

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weathers")
    fun fetchWeathers(): LiveData<List<CurrentWeatherData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weatherData: CurrentWeatherData)
}