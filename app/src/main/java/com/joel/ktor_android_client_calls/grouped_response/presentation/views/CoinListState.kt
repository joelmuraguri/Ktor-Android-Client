package com.joel.ktor_android_client_calls.grouped_response.presentation.views

import com.joel.ktor_android_client_calls.grouped_response.domain.model.Coins

data class CoinListState(
    val coins : List<Coins> = emptyList(),
    val isLoading : Boolean = false,
    val error : String = ""

)
