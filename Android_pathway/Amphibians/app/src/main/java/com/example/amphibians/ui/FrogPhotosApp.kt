package com.example.amphibians.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibians.R
import com.example.amphibians.ui.screens.FrogViewModel
import com.example.amphibians.ui.screens.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FrogPhotosApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(R.string.app_name),
                    )
                }
            )
        }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val frogViewModel: FrogViewModel=
                viewModel(factory = FrogViewModel.Factory)
            HomeScreen(
                frogUiState = frogViewModel.frogUiState,
                retryAction = frogViewModel::getFrogPhotos,
                modifier = Modifier.fillMaxSize(),
                contentPadding = it
            )
        }
    }
}