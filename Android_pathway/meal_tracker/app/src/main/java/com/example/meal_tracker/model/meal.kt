package com.example.meal_tracker.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class meal(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResource: Int
)
