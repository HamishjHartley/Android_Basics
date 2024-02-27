package com.example.bikephotos.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.bikephotos.R

@Composable
fun BikePhotoApp(modifier: Modifier = Modifier) {
    Column(
        modifier=modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This app displays bikes")
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = null)
    }
}