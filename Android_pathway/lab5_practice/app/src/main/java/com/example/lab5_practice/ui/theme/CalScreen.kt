package com.example.lab5_practice.ui.theme

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun CalScreen(
    calViewModel: calViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    var total = 0
    val activity = (LocalContext.current as Activity)
    val CalUiState by calViewModel.uiState.collectAsState()
    var openDialog = remember { mutableStateOf(false) }

    if (openDialog.value) {
        AlertDialog(
            title = {
                Text(text = "Day total: $total")
            },
            text = {
                Text(text = "dialogText")
            },
            onDismissRequest = {
                openDialog.value = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        activity.finish()
                    }
                ) {
                    Text("Exit")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        calViewModel().newDay()
                    }
                ) {
                    Text("New Day")
                }
            }
        )
    }

    Surface(
        color = Color.White,
    ) {
        Column(
        ) {
            Column(
                modifier = modifier
                    .align(alignment = Alignment.CenterHorizontally),
                //horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Day KCal",
                )
                Text(
                    text = "0%",
                )
                Text(
                    text = "$total /2000",
                )
            }
            Card(
            ) {
                OutlinedTextField(
                    //TODO Meal must not be empty
                    value = "",
                    singleLine = true,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally),
                    onValueChange = { },
                    label = { Text("Meal") },
                    isError = false,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                    )
                )
                OutlinedTextField(
                    //TODO KCal must be > 0
                    value = "",
                    singleLine = true,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally),
                    onValueChange = { },
                    label = { Text("KCal") },
                    isError = false,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { }
                    )
                )
                Button(
                    onClick = { openDialog.value = true },
                    modifier = modifier
                        .align(alignment = Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = "End Day"
                    )
                }

            }

        }
    }

}


@Composable
@Preview
fun CalScreenPreview() {
    Lab5_practiceTheme {
        CalScreen()
    }
}
