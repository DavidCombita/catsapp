package com.davidcombita.domain

import com.davidcombita.BuildConfig
import com.davidcombita.data.models.Cat
import com.davidcombita.data.response.CatsResponse
import com.davidcombita.repository.CatsRepository
import io.mockk.*
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking

import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class GetCatsUseCaseTest {

    @RelaxedMockK
    private lateinit var catsRepository: CatsRepository

    lateinit var getCatsUseCase: GetCatsUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        getCatsUseCase = GetCatsUseCase(catsRepository)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `test if you call repository and return empty list`() = runBlocking{
        //Given
        coEvery { catsRepository.getCatsInformation(BuildConfig.APIKEY) } returns Response.success(emptyList())
        //When
        getCatsUseCase(BuildConfig.APIKEY)
        //Then
        coVerify(exactly = 1) { catsRepository.getCatsInformation(BuildConfig.APIKEY) }
    }

    @Test
    fun `test call repository and return list`() = runBlocking{
        val catsResponse = Response.success(emptyList<Cat>())
        //Given
        coEvery { catsRepository.getCatsInformation(BuildConfig.APIKEY) } returns catsResponse
        //When
        val response = getCatsUseCase(BuildConfig.APIKEY)
        //Then
        coVerify(exactly = 1) { catsRepository.getCatsInformation(BuildConfig.APIKEY) }
        assert(response == catsResponse)
    }
}