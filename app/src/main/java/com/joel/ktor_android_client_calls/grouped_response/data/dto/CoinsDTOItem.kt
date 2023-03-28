package com.joel.ktor_android_client_calls.grouped_response.data.dto

import com.joel.ktor_android_client_calls.grouped_response.domain.model.Coins
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class CoinsDTO(
    val id: String,
    @SerialName("is_active")
    val isActive: Boolean,
    @SerialName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
) {
    fun toCoinsDomain() : Coins {
        return Coins(
            id =  id,
            symbol = symbol,
            isActive =  isActive,
            type = type,
            name = name,
            rank = rank
        )
    }
}