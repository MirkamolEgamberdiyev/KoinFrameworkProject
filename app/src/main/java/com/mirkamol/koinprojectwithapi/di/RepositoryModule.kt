package com.mirkamol.koinprojectwithapi.di

import com.mirkamol.koinprojectwithapi.data.repository.MainRepository
import org.koin.dsl.module

val repoModule = module {
    single {
        MainRepository(get())
    }
}