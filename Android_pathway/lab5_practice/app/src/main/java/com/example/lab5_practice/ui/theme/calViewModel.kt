package com.example.lab5_practice.ui.theme

import androidx.lifecycle.ViewModel
import com.example.lab5_practice.data.Meal
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class calViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CalUiState())
    val uiState: StateFlow<CalUiState> = _uiState.asStateFlow()

    var mealList: MutableList<Meal> = mutableListOf()

    init {
        newDay()
    }

    fun addMeal(meal: Meal) {
        mealList.add(meal)
    }

    fun newDay(){
        mealList.clear()
        _uiState.value = CalUiState()
    }
}