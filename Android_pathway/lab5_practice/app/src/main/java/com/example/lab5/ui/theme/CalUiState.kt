package com.example.lab5.ui

data class CalUiState(
    val kcal: Int = 0,
    val percentage: Float = 0.0f,
    val totalKcal: Int = 0,
    val mealNameList: List<String> = listOf("Breakfast","Morning Snack","Lunch","Afternoon Snack","Dinner"),
    val currentMeal: Int = 0
)

