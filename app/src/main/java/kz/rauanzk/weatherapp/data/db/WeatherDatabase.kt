package kz.rauanzk.weatherapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import kz.rauanzk.weatherapp.data.entity.CurrentWeatherData

@Database(entities = [CurrentWeatherData::class], version = 1, exportSchema = false)
abstract class WeatherDatabase : RoomDatabase() {
    abstract val weatherDao: WeatherDao
}