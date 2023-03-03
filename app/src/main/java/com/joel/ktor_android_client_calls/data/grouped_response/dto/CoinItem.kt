package com.joel.ktor_android_client_calls.data.grouped_response.dto

data class CoinItem(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)