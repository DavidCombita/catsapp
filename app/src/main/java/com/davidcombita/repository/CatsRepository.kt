package com.davidcombita.repository

import com.davidcombita.data.api.ApiCatsService
import com.davidcombita.data.models.Cat
import retrofit2.Response
import javax.inject.Inject

class CatsRepository @Inject constructor(
    private val apiCatsService: ApiCatsService
) {
    suspend fun getCatsInformation(apikey:String): Response<List<Cat>> = apiCatsService.getCats(apikey)
}