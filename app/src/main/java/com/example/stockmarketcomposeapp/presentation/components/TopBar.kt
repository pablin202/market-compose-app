package com.example.stockmarketcomposeapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(
    title: String,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, bottom = 16.dp)
    ) {
        Image(
            painter = painterResource(id = com.example.stockmarketcomposeapp.R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .size(28.dp)
        )
        Box(Modifier.fillMaxWidth()) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.primary,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(end = 32.dp, start = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewTopBar() {
    TopBar(title = "Stock Market")
}