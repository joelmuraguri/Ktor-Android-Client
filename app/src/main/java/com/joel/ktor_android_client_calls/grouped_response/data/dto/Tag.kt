package com.joel.ktor_android_client_calls.grouped_response.data.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Tag(
    @SerialName("coin_counter")
    val coinCounter: Int ? = null,
    @SerialName("ico_counter")
    val icoCounter: Int ? = null,
    val id: String ? = null,
    val name: String ? = null
)