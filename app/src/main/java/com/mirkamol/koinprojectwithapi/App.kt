package com.mirkamol.koinprojectwithapi

import android.app.Application
import com.mirkamol.koinprojectwithapi.di.appModule
import com.mirkamol.koinprojectwithapi.di.repoModule
import com.mirkamol.koinprojectwithapi.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, repoModule, viewModelModule))
        }
    }
}
