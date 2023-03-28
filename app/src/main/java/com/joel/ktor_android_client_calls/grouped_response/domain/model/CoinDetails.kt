package com.joel.ktor_android_client_calls.grouped_response.domain.model

data class CoinDetails(
    val id : String,
    val symbol : String,
    val isActive: Boolean,
    val type: String,
    val name : String,
    val message : String,
    val rank : Int,
    val logo : String
)
