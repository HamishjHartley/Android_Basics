package com.example.meal_tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.meal_tracker.ui.theme.Meal_trackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mealTrackerApp()
            }
        }
    }


@Preview
@Composable
fun mealTrackerPreview() {
    mealTrackerApp()
}

@Composable
fun mealTrackerApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {

    }
}