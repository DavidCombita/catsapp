package com.davidcombita.repository

import com.davidcombita.BuildConfig
import com.davidcombita.data.api.ApiCatsService
import com.davidcombita.data.respons.CatsResponse
import retrofit2.Response
import javax.inject.Inject

class CatsRepository @Inject constructor(
    private val apiCatsService: ApiCatsService
) {
    suspend fun getCatsInformation(apikey:String): Response<CatsResponse?> = apiCatsService.getCats(apikey)
}