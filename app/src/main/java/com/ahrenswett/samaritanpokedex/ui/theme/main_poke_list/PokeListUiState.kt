package com.ahrenswett.samaritanpokedex.ui.theme.main_poke_list

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class PokeListUiState(
    val pokeList: Flow<List<String>> = emptyFlow(),
)