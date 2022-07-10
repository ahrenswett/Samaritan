package com.ahrenswett.samaritanpokedex.ui.main_poke_list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ahrenswett.samaritanpokedex.R
import com.ahrenswett.samaritanpokedex.navigation.UiEvent


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
    viewModel: PokeListViewModel )
{


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
                            .alpha(1F).
                            then(Modifier.fillMaxWidth()).then(Modifier.fillMaxHeight()),
                    )
                }

            )}
        ){
        LazyVerticalGrid(
            // TODO: figure out network calls based on items loaded in the grid
            cells = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ){
          // add on click listener to each item in the grid
//          viewModel.pokeList.forEachIndexed{ index, pokemon ->
//                item(span = { GridItemSpan(itemColumn)}  ) {
//                    Text("Item is ${pokemon.name}\n${pokemon.url}", itemModifier)
//                }
//            }
        }
    }
}