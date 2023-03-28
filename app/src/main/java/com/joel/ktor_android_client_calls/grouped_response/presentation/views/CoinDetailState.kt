package com.joel.ktor_android_client_calls.grouped_response.presentation.views

import com.joel.ktor_android_client_calls.grouped_response.domain.model.CoinDetails

data class CoinDetailState(
    val details : CoinDetails ?  = null,
    val isLoading : Boolean = false,
    val message : String = ""

)
