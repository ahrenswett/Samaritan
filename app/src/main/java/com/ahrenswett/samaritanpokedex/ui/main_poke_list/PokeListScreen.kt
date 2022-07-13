package com.ahrenswett.samaritanpokedex.ui.main_poke_list

import android.content.ClipData
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.ahrenswett.samaritanpokedex.R
import com.ahrenswett.samaritanpokedex.domain.models.Pokemon
import com.ahrenswett.samaritanpokedex.navigation.Routes
import com.ahrenswett.samaritanpokedex.navigation.UiEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.toList
import kotlinx.serialization.builtins.serializer
import okhttp3.internal.notify


/* Shows a list of Pokemon in a grid format.
 * If a user selects one of the items, they are taken to the detail page of that item.
 * Scrolling list loads more items.
 * Floating action Poké ball button takes the user to the list of captured Pokemon.
 */


@OptIn(ExperimentalFoundationApi::class)
@Composable
// Gets data from the PokeListViewModel passes user input to PokeListViewModel
fun PokeListScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: PokeListViewModel
){

    val poke = viewModel.pokemonFlowList.collectAsState(initial = emptyList())


    val itemModifier = Modifier
        .border(1.dp, Black, RoundedCornerShape(5.dp))
        .height(80.dp)
        .wrapContentSize()
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true){
        // TODO: Define

    }

    Scaffold(
        topBar = {
            Icon(
                painter = painterResource(id = R.drawable.title_image),
                contentDescription = "Go to captured Poké list",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
            )
                 },
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.onEvent(PokeListEvents.onPokeBallClick) },
                content = {
                    Icon(
                        //TODO: Figure out why icon is not showing properly
                        painter = painterResource(id = R.drawable.poke_ball),
                        contentDescription = "Go to captured Poké list",
                        Modifier
                            .size(48.dp)
                            .alpha(1F)
                            .then(Modifier.fillMaxWidth())
                            .then(Modifier.fillMaxHeight()),
                    )
                }

            )}
        ){
        LazyVerticalGrid(
            // TODO: figure out network calls based on items loaded in the grid
            cells = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.clickable {
                viewModel.onEvent(PokeListEvents.OnPokeClick(poke as Pokemon))
            }
        ){
//           add on click listener to each item in the grid
            poke.value.forEachIndexed{ index, pokemon ->
                item(
                    span = { GridItemSpan(itemColumn) },
                    ) {
                    Text("Pokemon is ${pokemon.name}", itemModifier)
                    if(pokemon.Stats != null) {
                        Text(text = "${pokemon.Stats}")
                    }
                }
            }
        }
    }
}
