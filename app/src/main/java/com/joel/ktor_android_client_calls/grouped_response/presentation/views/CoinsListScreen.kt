package com.joel.ktor_android_client_calls.grouped_response.presentation.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.joel.ktor_android_client_calls.grouped_response.presentation.views.components.CoinItem

@Composable
fun CoinsListScreen(
    viewModel: CoinListViewModel = hiltViewModel()
){


    val coinListState = viewModel.coinsState.value

    Box(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(columns = GridCells.Fixed(2)){
            items(coinListState.coins.size){ index ->
                CoinItem(coins = coinListState.coins[index])

            }
        }
        if (coinListState.error.isNotBlank()){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(
                            vertical = 8.dp
                        )
                ) {
                    Text(
                        text = coinListState.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)

                    )
                    Button(onClick = { viewModel.getCoins() }) {
                        Text(text = "Reload")
                    }
                }
            }
        }
        if (coinListState.isLoading){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .scale(0.5f)
                )
            }
        }
    }

}