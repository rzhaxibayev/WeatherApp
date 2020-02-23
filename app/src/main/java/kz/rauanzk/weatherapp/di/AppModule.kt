package kz.rauanzk.weatherapp.di

import kz.rauanzk.weatherapp.data.repository.WeatherRepository
import org.koin.dsl.module

val appModule = module {
    single { WeatherRepository(get(), get()) }
}