package com.example.amphibians.ui.screens

import android.text.Spannable.Factory
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibians.FrogApplication
import com.example.amphibians.data.FrogPhotosRepository
import com.example.amphibians.model.FrogPhoto
import kotlinx.coroutines.launch
import kotlinx.serialization.SerialName
import retrofit2.HttpException
import java.io.IOException

sealed interface FrogUiState{
    data class Success(var frogCard: List<FrogPhoto>) : FrogUiState
    object Error : FrogUiState
    object Loading : FrogUiState
}

class FrogViewModel(private val frogPhotosRepository: FrogPhotosRepository) : ViewModel() {
    //Mutable state which stores the status of most recent request
    var frogUiState: FrogUiState by mutableStateOf(FrogUiState.Loading)
        private set

    init {
        getFrogPhotos()
    }

    //Gets frog photos from Frog API service
    fun getFrogPhotos() {
        viewModelScope.launch {
            frogUiState = FrogUiState.Loading
            try {
                frogUiState = FrogUiState.Success(frogPhotosRepository.getFrogPhotos())
            } catch (e: IOException) {
                FrogUiState.Error
            } catch (e: HttpException) {
                FrogUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                        as FrogApplication)
                val frogPhotosRepository = application.container.frogPhotosRepository
                FrogViewModel(frogPhotosRepository = frogPhotosRepository)
            }
        }
    }
}
