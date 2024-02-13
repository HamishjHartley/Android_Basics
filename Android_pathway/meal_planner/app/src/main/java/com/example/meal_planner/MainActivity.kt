import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meal_planner.R
import com.example.meal_planner.model.Meal


@Composable
fun AddRemoveListScreen() {
    var itemList by remember { mutableStateOf<List<Meal>>(listOf()) }
    var newItemText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Display the scrollable list
        LazyColumn {
            items(itemList) { item ->
                Text(text = item, modifier = Modifier.padding(8.dp))
            }
        }

        // Text field for adding new items
        OutlinedTextField(
            value = newItemText,
            onValueChange = { newItemText = it },
            label = { Text(text = "New Item") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    if (newItemText.isNotBlank()) {
                        itemList = itemList + newItemText
                        newItemText = ""
                    }
                }
            ),
            trailingIcon = {
                if (newItemText.isNotBlank()) {
                    IconButton(
                        onClick = {
                            newItemText = ""
                        }
                    ) {
                        Icon(imageVector = Icons.Default.Clear, contentDescription = null)
                    }
                }
            }
        )

        // Button for adding new item
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                onClick = {
                    if (newItemText.isNotBlank()) {
                        itemList = itemList + newItemText
                        newItemText = ""
                    }
                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AddRemoveListScreenPreview() {
    AddRemoveListScreen()
}