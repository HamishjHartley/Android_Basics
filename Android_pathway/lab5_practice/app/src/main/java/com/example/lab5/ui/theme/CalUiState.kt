package com.example.lab5.ui.theme

data class CalUiState(
    val Kcal: Int = 0,
    val percentage: Float = 0.0f,
    val totalKcal: Int = 0,
    val mealNameList: List<String> = listOf("Breakfast","Morning Snack","Lunch","Afternoon Snack","Dinner"),
    val mealKcalList: List<Int> = listOf(0,0,0,0,0),
    val currentMeal: Int = 0
)

