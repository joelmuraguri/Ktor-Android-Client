package com.joel.ktor_android_client_calls.grouped_response.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joel.ktor_android_client_calls.grouped_response.presentation.views.CoinDetailsScreen
import com.joel.ktor_android_client_calls.grouped_response.presentation.views.CoinsListScreen

@Composable
fun GroupedResponseNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoutes.CoinsListScreen.route){
        composable(route = NavRoutes.CoinsListScreen.route){
            CoinsListScreen(navController = navController)
        }
        composable(route = NavRoutes.CoinDetailScreen.route + "/{coin_id}"){
            CoinDetailsScreen(
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
    }

}