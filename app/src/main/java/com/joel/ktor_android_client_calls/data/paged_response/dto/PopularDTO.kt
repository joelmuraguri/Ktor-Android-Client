package com.joel.ktor_android_client_calls.data.paged_response.dto

import com.joel.ktor_android_client_calls.domain.paged_response.model.PopularMovie
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class PopularDTO(
    val adult: Boolean,
    @SerialName("backdrop_path")
    val backdropPath: String,
    @SerialName("genre_ids")
    val genreIds: List<Int>,
    val id: Int,
    @SerialName("original_language")
    val originalLanguage: String,
    @SerialName("original_title")
    val original_title: String,
    val overview: String,
    val popularity: Double,
    @SerialName("poster_path")
    val posterPath: String,
    @SerialName("release_date")
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    @SerialName("vote_average")
    val voteAverage: Double,
    @SerialName("vote_count")
    val voteCount: Int
) {


    fun toPopularMovie() : PopularMovie{
        return PopularMovie(
            id = id,
            title = title,
            overView = overview,
            posterPath = posterPath
        )
    }

}


