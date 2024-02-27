package com.example.amphibians.ui.screens

import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibians.R
import com.example.amphibians.model.FrogPhoto

@Composable
fun HomeScreen(
    frogUiState: FrogUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    when(frogUiState) {
        is FrogUiState.Loading -> LoadingScreen()
        is FrogUiState.Success ->
            FrogListScreen(
                frogs = frogUiState.frogCard,
                modifier = modifier
            )
        else -> ErrorScreen(retryAction, modifier)

    }

}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading),
        modifier = modifier
    )
}

/**
 * The home screen displaying error message with re-attempt button.
 */
@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(R.string.loading_failed))
        Button(onClick = retryAction) {
            Text(stringResource(R.string.retry))
        }
    }
}

@Composable
fun FrogPhotoCard(frog: FrogPhoto, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            Text(
                text = frog.name + "(" + frog.type + ")"
            )
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(frog.imgSrc)
                    .crossfade(true)
                    .build(),
                contentDescription = frog.description,
                contentScale = ContentScale.Crop
            )
            Text(
                text = frog.description
            )
        }
    }
}


@Composable
fun FrogListScreen(
    frogs: List<FrogPhoto>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ){
        items(
            items = frogs,
            key = { frog ->
                frog.name
            }
        ) {frog ->
            FrogPhotoCard(frog = frog, modifier = Modifier.fillMaxSize())
        }
    }
}





