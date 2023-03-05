package com.joel.ktor_android_client_calls.presentation.movie

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MovieList(
    viewModel: MovieViewModel = hiltViewModel()
){

    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
       LazyVerticalGrid(columns = GridCells.Fixed(2)){
           items(state.movies.size){ index ->
               MovieCard(movie = state.movies[index])

           }
       }
        if (state.error.isNotBlank()){
            Text(
                text = state.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading){
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