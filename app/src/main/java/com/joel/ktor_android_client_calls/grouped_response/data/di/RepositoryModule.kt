package com.joel.ktor_android_client_calls.grouped_response.data.di

import com.joel.ktor_android_client_calls.grouped_response.data.remote.network.CoinsServiceImpl
import com.joel.ktor_android_client_calls.grouped_response.data.repo.CoinsRepoImpl
import com.joel.ktor_android_client_calls.grouped_response.domain.repo.CoinsRepo
import com.joel.ktor_android_client_calls.grouped_response.domain.use_case.GetCoinsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    @Singleton
    fun providesRepository(
        serviceImpl: CoinsServiceImpl
    ) : CoinsRepo {
       return CoinsRepoImpl(serviceImpl)
    }

    @Provides
    @Singleton
    fun providesGetCoinUseCase(
        repo: CoinsRepo
    ) : GetCoinsUseCase{
        return GetCoinsUseCase(repo)
    }

}