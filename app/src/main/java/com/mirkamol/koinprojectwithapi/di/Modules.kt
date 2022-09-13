package com.mirkamol.koinprojectwithapi.di

import android.content.Context
import com.mirkamol.koinprojectwithapi.BuildConfig
import com.mirkamol.koinprojectwithapi.data.api.ApiHelper
import com.mirkamol.koinprojectwithapi.data.api.ApiHelperImpl
import com.mirkamol.koinprojectwithapi.data.api.ApiService
import com.mirkamol.koinprojectwithapi.utils.NetworkHelper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
//    single { provideOkHttpClient() }
    single { provideRetrofit(BuildConfig.BASE_URL) }
    single { provideApiService(get()) }
    single { provideNetworkHelper(androidContext()) }
    single<ApiHelper> {
        return@single ApiHelperImpl(get())
    }
}

private fun provideNetworkHelper(context:Context) = NetworkHelper(context)

private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
} else OkHttpClient
    .Builder()
    .build()

private fun provideRetrofit(
    BASE_URL: String
): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()


private fun provideApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)
