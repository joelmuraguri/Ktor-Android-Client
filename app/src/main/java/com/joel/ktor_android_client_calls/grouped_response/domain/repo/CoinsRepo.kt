package com.joel.ktor_android_client_calls.grouped_response.domain.repo

import com.joel.ktor_android_client_calls.common.ResourceResult
import com.joel.ktor_android_client_calls.grouped_response.domain.model.CoinDetails
import com.joel.ktor_android_client_calls.grouped_response.domain.model.Coins
import kotlinx.coroutines.flow.Flow

interface CoinsRepo {

    suspend fun getCoins() : Flow<ResourceResult<List<Coins>>>

    suspend fun getCoinDetails(coinId : String) : Flow<ResourceResult<CoinDetails>>
}