package com.example.meal_planner.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Meal(
    @StringRes val stringResourceId: String,
    @DrawableRes val imageResourceId: Int
)
