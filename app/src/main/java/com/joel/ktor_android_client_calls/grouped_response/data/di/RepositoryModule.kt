package com.joel.ktor_android_client_calls.grouped_response.data.di

import com.joel.ktor_android_client_calls.grouped_response.data.remote.network.CoinsService
import com.joel.ktor_android_client_calls.grouped_response.data.repo.CoinsRepository
import com.joel.ktor_android_client_calls.grouped_response.domain.repo.CoinsRepo
import com.joel.ktor_android_client_calls.grouped_response.domain.use_case.GetCoinDetailsUseCase
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
        service: CoinsService
    ) : CoinsRepo {
       return CoinsRepository(service)
    }

    @Provides
    @Singleton
    fun providesGetCoinUseCase(
        repo: CoinsRepo
    ) : GetCoinsUseCase{
        return GetCoinsUseCase(repo)
    }

    @Provides
    @Singleton
    fun providesGetCoinDetailsUseCase(
        repo: CoinsRepo
    ) : GetCoinDetailsUseCase{
        return GetCoinDetailsUseCase(repo)
    }
}