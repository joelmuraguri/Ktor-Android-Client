package com.joel.ktor_android_client_calls.grouped_response.data.dto

import com.joel.ktor_android_client_calls.grouped_response.domain.model.CoinDetails
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class CoinDetailsDTO(
    val description: String,
    @SerialName("development_status")
    val developmentStatus: String ? = null,
    @SerialName("first_data_at")
    val firstDataAt: String,
    @SerialName("hardware_wallet")
    val hardwareWallet: Boolean ? = false,
    @SerialName("hash_algorithm")
    val hashAlgorithm: String ?= null,
    val id: String,
    @SerialName("is_active")
    val isActive: Boolean,
    @SerialName("is_new")
    val isNew: Boolean,
    @SerialName("last_data_at")
    val lastDataAt: String,
    val links: Links,
    @SerialName("links_extended")
    val linksExtended: List<LinksExtended>,
    val logo: String,
    val message: String,
    val name: String,
    @SerialName("open_source")
    val openSource: Boolean ? = false,
    @SerialName("org_structure")
    val orgStructure: String ? = null,
    @SerialName("proof_type")
    val proofType: String ? = null,
    val rank: Int,
    @SerialName("started_at")
    val startedAt: String ? = null,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<Team>,
    val type: String,
    @SerialName("whitepaper")
    val whitePaper: Whitepaper
) {
    fun toCoinDetailsDomain() : CoinDetails {
        return CoinDetails(
            id = id,
            rank = rank,
            symbol = symbol,
            name = name,
            isActive = isActive,
            type = type,
            message = message,
            logo = logo,
            team = team,
            tags = tags
        )
    }
}

