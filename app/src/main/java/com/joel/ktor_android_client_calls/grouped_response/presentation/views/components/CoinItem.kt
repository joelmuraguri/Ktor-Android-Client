package com.joel.ktor_android_client_calls.grouped_response.presentation.views.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joel.ktor_android_client_calls.grouped_response.domain.model.Coins

@Composable
fun CoinItem(
    coins: Coins,
    onItemClick : (Coins) -> Unit
){

    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .clickable { onItemClick(coins) }
            .padding(12.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = coins.symbol,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = coins.name
            )
        }
    }
}