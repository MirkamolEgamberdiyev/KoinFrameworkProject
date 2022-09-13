package com.mirkamol.koinprojectwithapi.data.repository

import com.mirkamol.koinprojectwithapi.data.api.ApiHelper


class MainRepository (private val apiHelper: ApiHelper) {

    suspend fun getUsers() =  apiHelper.getUsers()

}