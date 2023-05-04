package com.davidcombita.data.api

import com.davidcombita.data.models.Cat
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiCatsService {

    @GET("v1/breeds")
    suspend fun getCats(@Header("x-api-key") apiKey:String): Response<List<Cat>>
}