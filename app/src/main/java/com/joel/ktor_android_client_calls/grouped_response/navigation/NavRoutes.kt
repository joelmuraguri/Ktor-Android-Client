package com.joel.ktor_android_client_calls.grouped_response.navigation

sealed class NavRoutes(val route: String) {
    object CoinsListScreen: NavRoutes("coins_list_screen")
    object CoinDetailScreen: NavRoutes("coin_detail_screen")
}