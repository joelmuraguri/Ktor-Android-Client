package com.joel.ktor_android_client_calls.data.di

import com.joel.ktor_android_client_calls.common.MovieHttpClientFactory
import com.joel.ktor_android_client_calls.data.paged_response.network.MovieApi
import com.joel.ktor_android_client_calls.data.paged_response.repository.MovieRepository
import com.joel.ktor_android_client_calls.domain.paged_response.repo.MovieRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieNetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(clientFactory: MovieHttpClientFactory) : HttpClient= clientFactory.getHttpClient()

    @Provides
    @Singleton
    fun provideRepository(api: MovieApi) : MovieRepo {
       return MovieRepository(api)
    }



}