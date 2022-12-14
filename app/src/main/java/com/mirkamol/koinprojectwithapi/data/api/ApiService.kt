package com.mirkamol.koinprojectwithapi.data.api

import com.mirkamol.koinprojectwithapi.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}