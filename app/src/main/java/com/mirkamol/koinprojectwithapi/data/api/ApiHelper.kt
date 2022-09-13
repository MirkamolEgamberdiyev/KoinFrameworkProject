package com.mirkamol.koinprojectwithapi.data.api

import com.mirkamol.koinprojectwithapi.data.model.User
import retrofit2.Response

interface ApiHelper {
    suspend fun getUsers(): Response<List<User>>
}