package kz.rauanzk.weatherapp.di

import kz.rauanzk.weatherapp.ui.detail.DetailViewModel
import kz.rauanzk.weatherapp.ui.history.HistoryViewModel
import kz.rauanzk.weatherapp.ui.main.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MainActivityViewModel(get()) }

    viewModel { HistoryViewModel(get()) }

    viewModel { DetailViewModel() }
}