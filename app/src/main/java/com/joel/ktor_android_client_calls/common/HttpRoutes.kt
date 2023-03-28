package com.joel.ktor_android_client_calls.common

object HttpRoutes {

    private const val TMDB_BASE_URL = "https://api.themoviedb.org/3/movie"
    const val POPULAR = "$TMDB_BASE_URL/popular"

    const val COIN_PAPRIKA_BASE_URL = "https://api.coinpaprika.com/v1/coins"

    const val GET_COINS = "https://api.coinpaprika.com/v1/coins"

    const val GET_COIN_DETAILS = "https://api.coinpaprika.com/v1/coins"

    const val PARAM_COIN_ID = "coin_id"

    val api = "api_key=facd5b10ac4ad49bf6c5cce3ff0a0400"
}