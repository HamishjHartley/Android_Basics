package com.example.lab5.ui.theme

import androidx.lifecycle.ViewModel
import com.example.lab5.data.Meal
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class CalViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CalUiState())
    val uiState: StateFlow<CalUiState> = _uiState.asStateFlow()

    var mealList: MutableList<Meal> = mutableListOf()

    init {
        newDay()
    }

    fun addMeal(meal: Meal) {
        mealList.add(meal)
    }

    fun nextMeal(currentMeal: Int){
        _uiState.value.currentMeal.plus(1)
        _uiState.update { currentState ->
            currentState.copy(
                Kcal = 0,
                percentage = 0.0f,
                totalKcal = 0,
                currentMeal = currentMeal+1
            )
        }
    }
    fun newDay(){
        mealList.clear()
        _uiState.value = CalUiState()
    }
}