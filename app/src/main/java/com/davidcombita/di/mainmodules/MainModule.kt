package com.davidcombita.di.mainmodules

import com.davidcombita.api.ApiCatsService
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
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiCatsService = retrofit.create(ApiCatsService::class.java)

    
}