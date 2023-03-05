package com.joel.ktor_android_client_calls.domain.paged_response.model

data class PopularMovie(
    val id : Int,
    val title : String,
    val overView : String,
    val posterPath : String,
)
