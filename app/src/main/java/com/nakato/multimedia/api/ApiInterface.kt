package com.nakato.multimedia.api

import com.nakato.multimedia.model.LoginRequest
import com.nakato.multimedia.model.LoginResponse
import com.nakato.multimedia.model.PhotoResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiInterface {
    @Multipart
    @POST("/selfie")
    suspend fun uploadPhoto(
        @Part caption : MultipartBody.Part,
        @Part image : MultipartBody.Part
    ):Response<PhotoResponse>

    @POST("/auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>
}


