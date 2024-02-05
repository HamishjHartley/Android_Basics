package com.example.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab1.ui.theme.Lab1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Content()
                }
            }
        }
    }
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    var itemPadding:Int = 30
    var calorieRemaining:Int by remember { mutableIntStateOf(2000) }
    val calorieMax:Int = 2000
    var caloriePercentage:Float = calorieRemaining.toFloat()/calorieMax.toFloat()
    var calorieString:String = ((caloriePercentage*100).toInt()).toString()
    var caloriePercentageIndicator:Float = 0.0F
    if(caloriePercentage < 0.0F){
        caloriePercentageIndicator = 0.0F
    }
    else{
        caloriePercentageIndicator = caloriePercentage
    }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier= modifier
        .fillMaxSize())

    {
        Text(
            text = "$calorieRemaining KCal Remaining",
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(itemPadding.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(fraction =0.75F),
            fontSize = 16.sp
        )

        Text(
            text = "$calorieString%",
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(itemPadding.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(fraction =0.75F),
            fontSize = 16.sp

        )
        CircularProgressIndicator(
            progress = caloriePercentageIndicator,
            color = Color.Green,
            strokeCap = StrokeCap.Square,
            modifier = modifier
                .padding(itemPadding.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(fraction = 0.75F)
                .fillMaxSize(fraction = 0.5F)
        )
        Button(onClick = { calorieRemaining -= 200 },
                modifier = modifier
            .padding(itemPadding.dp)
            .align(Alignment.CenterHorizontally)
            .fillMaxWidth(fraction =0.75F))

        {
            Text("-200")

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab1Theme {
        Content()
    }
}