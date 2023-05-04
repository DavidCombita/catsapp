package com.davidcombita.di.mainmodules

import com.davidcombita.data.api.ApiCatsService
import com.davidcombita.domain.GetCatsUseCase
import com.davidcombita.repository.CatsRepository
import com.davidcombita.viewmodels.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object MainModule {

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiCatsService = retrofit.create(ApiCatsService::class.java)

    @Provides
    fun provideCatsRepository(apiCatsService: ApiCatsService): CatsRepository = CatsRepository(apiCatsService)

    @Provides
    fun provideCatsUseCase(catsRepository: CatsRepository): GetCatsUseCase = GetCatsUseCase(catsRepository)

    @Provides
    fun provideMainViewModel(getCatsUseCase: GetCatsUseCase): MainViewModel = MainViewModel(getCatsUseCase)
}