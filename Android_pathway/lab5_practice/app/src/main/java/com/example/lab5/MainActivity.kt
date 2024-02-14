package com.example.lab5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.example.lab5.ui.theme.Lab5_practiceTheme
import com.example.lab5.ui.theme.CalScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab5_practiceTheme {
                Surface {
                    CalScreen()
                }
            }
        }
    }
}