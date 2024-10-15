package com.nakato.multimedia.repository

import com.nakato.multimedia.api.ApiClient
import com.nakato.multimedia.api.ApiInterface
import com.nakato.multimedia.model.LoginRequest
import com.nakato.multimedia.model.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class LoginRepository {
    val apiClient = ApiClient.buildClient(ApiInterface::class.java)

    suspend fun login(loginRequest: LoginRequest): Response<LoginResponse>{
        return withContext(Dispatchers.IO){
            apiClient.login(loginRequest)
        }

    }
}