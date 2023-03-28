package com.joel.ktor_android_client_calls.grouped_response.domain.use_case

import com.joel.ktor_android_client_calls.common.ResourceResult
import com.joel.ktor_android_client_calls.grouped_response.domain.model.Coins
import com.joel.ktor_android_client_calls.grouped_response.domain.repo.CoinsRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repo: CoinsRepo
) {

    suspend operator fun invoke() : Flow<ResourceResult<List<Coins>>>{
        return repo.getCoins()
    }

}