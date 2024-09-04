package com.example.a30daysapp

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.a30daysapp.model.Animal

@Composable
fun AnimalListItem(
    animal: Animal,
    modifier: Modifier = Modifier
) {

    var visible by remember { mutableStateOf(false) }

    val paddingSmall = dimensionResource(R.dimen.padding_small)
    val paddingMedium = dimensionResource(R.dimen.padding_medium)

    val onClick: () -> Unit = {
            visible = !visible
    }

    Card(
        modifier = modifier
            .padding(start = paddingMedium, end = paddingMedium,
                bottom = paddingSmall)
    ) {
        Column {
            Text(
                text = animal.day,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(
                    start = paddingSmall,
                    bottom = paddingSmall,
                    top = paddingSmall
                    ),
            )
            Text(
                text = stringResource(animal.nameId),
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(start = paddingSmall, bottom = paddingSmall),
            )
            AnimalImage(onClick, animalImageId = animal.imageId)
            AnimalDescription(visible, stringResource(animal.description))
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimalDescription(visible: Boolean, text: String, modifier: Modifier = Modifier) {
    AnimatedVisibility(
        visible = visible,
        enter = expandVertically(
                    // Expand from the top.
                    expandFrom = Alignment.Top
                )
                + fadeIn(animationSpec = tween(durationMillis = 250))
                + slideInVertically(initialOffsetY = { -it }),
        exit = shrinkVertically()
               + fadeOut(animationSpec = tween(durationMillis = 100))
               + slideOutVertically(targetOffsetY = { -it })
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_small)),
        )
    }
}

@Composable
fun AnimalImage(onClick: () -> Unit,@DrawableRes animalImageId: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        horizontalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(animalImageId),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(dimensionResource(R.dimen.image_height))
                .padding(bottom = dimensionResource(R.dimen.padding_small))
                .fillMaxWidth(),
        )
    }
}

@Composable
fun AnimalList(animals: List<Animal>, modifier: Modifier = Modifier) {
    LazyColumn() {
        items(animals) {animal ->
            AnimalListItem(animal)
        }
    }
}