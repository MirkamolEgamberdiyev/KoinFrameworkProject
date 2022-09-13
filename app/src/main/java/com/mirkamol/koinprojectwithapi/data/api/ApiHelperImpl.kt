package com.mirkamol.koinprojectwithapi.data.api

import com.mirkamol.koinprojectwithapi.data.model.User
import retrofit2.Response

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {
    override suspend fun getUsers(): Response<List<User>> = apiService.getUsers()
}