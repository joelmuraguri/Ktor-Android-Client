package com.joel.ktor_android_client_calls.grouped_response.data.di

import com.joel.ktor_android_client_calls.grouped_response.data.remote.network.CoinHttpClientFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(clientFactory: CoinHttpClientFactory) : HttpClient = clientFactory.getHttpClient()

}