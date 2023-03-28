package com.joel.ktor_android_client_calls.grouped_response.domain.model

import com.joel.ktor_android_client_calls.grouped_response.data.dto.Tag
import com.joel.ktor_android_client_calls.grouped_response.data.dto.Team

data class CoinDetails(
    val id : String,
    val symbol : String,
    val isActive: Boolean,
    val type: String,
    val name : String,
    val message : String,
    val rank : Int,
    val logo : String,
    val team : List<Team>,
    val tags : List<Tag>
)
