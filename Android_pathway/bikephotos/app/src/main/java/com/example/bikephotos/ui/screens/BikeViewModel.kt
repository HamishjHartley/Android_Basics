package com.example.bikephotos.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.io.IOException


sealed interface BikeUiState {
    data class Success(val photos: String) : BikeUiState
    object Error : BikeUiState
    object Loading : BikeUiState
}

class BikeViewModel() : ViewModel() {

    var bikeUiState : BikeUiState by mutableStateOf(BikeUiState.Loading)
        private set

    fun getBikePhotos() {
        viewModelScope.launch {
            bikeUiState = BikeUiState.Loading
            bikeUiState = try {
                val listResult = bikePhotosRepository.
            } catch (e: IOException) {

            }
        }
    }

}