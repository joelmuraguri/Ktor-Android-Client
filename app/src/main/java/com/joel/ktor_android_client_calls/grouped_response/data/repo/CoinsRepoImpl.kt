package com.joel.ktor_android_client_calls.grouped_response.data.repo

import com.joel.ktor_android_client_calls.common.ResourceResult
import com.joel.ktor_android_client_calls.grouped_response.data.remote.network.CoinsServiceImpl
import com.joel.ktor_android_client_calls.grouped_response.domain.model.CoinDetails
import com.joel.ktor_android_client_calls.grouped_response.domain.model.Coins
import com.joel.ktor_android_client_calls.grouped_response.domain.repo.CoinsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class CoinsRepoImpl(
    private val service : CoinsServiceImpl
) : CoinsRepo {

    override suspend fun getCoins(): Flow<ResourceResult<List<Coins>>> = flow{
        emit(ResourceResult.Loading())
        try {
            val response = service.getCoins()
            emit(ResourceResult.Success(response.map { it.toCoinsDomain() }))
        } catch (e : IOException){
            emit(ResourceResult.Error(message = "Couldn't reach Server. Check your Internet Connection"))
        }
    }

    override suspend fun getCoinDetails(coinId: String): Flow<ResourceResult<CoinDetails>> {
        TODO("Not yet implemented")
    }
}