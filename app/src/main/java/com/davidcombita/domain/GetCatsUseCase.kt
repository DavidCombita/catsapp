package com.davidcombita.domain

import com.davidcombita.data.models.Cat
import com.davidcombita.repository.CatsRepository
import retrofit2.Response
import javax.inject.Inject

class GetCatsUseCase @Inject constructor(
    private val catsRepository: CatsRepository
){
    suspend operator fun invoke(apikey: String): Response<List<Cat>> = catsRepository.getCatsInformation(apikey)
}