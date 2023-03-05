package com.joel.ktor_android_client_calls.data.paged_response.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class PopularResponse(
    val page: Int,
    val results: List<PopularDTO>,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("total_results")
    val totalResults: Int

)