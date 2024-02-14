package com.example.lab5.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class CalViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CalUiState())
    val uiState: StateFlow<CalUiState> = _uiState.asStateFlow()
    var mealKcalList: MutableList<Int> = mutableListOf(0,0,0,0,0)

    init {
        newDay()
    }

    fun addMeal(kcal: Int) {
        mealKcalList[_uiState.value.currentMeal] =kcal
    }

    fun nextMeal(currentMeal: Int){
        _uiState.value.currentMeal.plus(1)
        _uiState.update { currentState ->
            currentState.copy(
                kcal = 0,
                percentage = 0.0f,
                totalKcal = 0,
                currentMeal = currentMeal+1
            )
        }
    }
    fun newDay(){

        _uiState.value = CalUiState()
    }
}
