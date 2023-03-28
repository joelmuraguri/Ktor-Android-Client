package com.joel.ktor_android_client_calls.grouped_response.presentation.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent

@Composable
fun CoinDetailsScreen(
    viewModel: CoinDetailsViewModel = hiltViewModel(),
    onBackPressed : () -> Unit
){

    val coinDetailState = viewModel.coinDetailState.value
    Box(
            modifier = Modifier
                .fillMaxSize()
                .padding()
        ) {
            coinDetailState.details?.let { coin ->
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    SubcomposeAsyncImage(
                        model = coin.logo,
                        contentDescription = coin.name,
                        modifier = Modifier
                            .size(300.dp),
                        contentScale = ContentScale.FillBounds
                    ) {
                        val state = painter.state
                        if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .scale(0.5f)
                            )
                        } else {
                            SubcomposeAsyncImageContent()
                        }
                    }

                    Text(
                        text = coin.name,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = coin.symbol
                    )
                }
            }

            if (coinDetailState.message.isNotBlank()){
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
                            text = coinDetailState.message,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)

                        )
                        Button(onClick = { viewModel.getCoinsDetails(viewModel.coinDetailState.value.details!!.id) }) {
                            Text(text = "Reload")
                        }
                    }
                }
            }
            if (coinDetailState.isLoading){
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .scale(0.5f)
                )
            }
        }
}