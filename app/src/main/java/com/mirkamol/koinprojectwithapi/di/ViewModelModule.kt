package com.mirkamol.koinprojectwithapi.di

import com.mirkamol.koinprojectwithapi.ui.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(get(),get())
    }
}