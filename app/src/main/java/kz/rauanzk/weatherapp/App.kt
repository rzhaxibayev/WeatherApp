package kz.rauanzk.weatherapp

import android.app.Application
import kz.rauanzk.weatherapp.di.appModule
import kz.rauanzk.weatherapp.di.databaseModule
import kz.rauanzk.weatherapp.di.networkModule
import kz.rauanzk.weatherapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(appModule, viewModelModule, networkModule, databaseModule))
        }
    }
}