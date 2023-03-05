package com.joel.ktor_android_client_calls.presentation.movie

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.joel.ktor_android_client_calls.BuildConfig
import com.joel.ktor_android_client_calls.domain.paged_response.model.PopularMovie

@Composable
fun MovieCard(
    movie : PopularMovie
){

    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SubcomposeAsyncImage(
                model = BuildConfig.ORIGINAL_IMAGE_URL + movie.posterPath,
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
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
            Text(text = movie.title)
        }
    }
}