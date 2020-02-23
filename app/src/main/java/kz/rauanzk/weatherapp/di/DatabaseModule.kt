package kz.rauanzk.weatherapp.di

import android.app.Application
import androidx.room.Room
import kz.rauanzk.weatherapp.data.db.WeatherDao
import kz.rauanzk.weatherapp.data.db.WeatherDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideWeatherDatabase(app: Application): WeatherDatabase {
        return Room.databaseBuilder(app, WeatherDatabase::class.java, "weather.database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun provideWeatherDao(database: WeatherDatabase): WeatherDao {
        return database.weatherDao
    }

    single { provideWeatherDatabase(androidApplication()) }
    single { provideWeatherDao(get()) }
}

