package com.ahrenswett.samaritanpokedex.ui.main_poke_list

import com.ahrenswett.samaritanpokedex.domain.models.Pokemon


/**
 * Declare the events on the UI and what they should pass PokeListViewModel
 */
sealed class PokeListEvents {
    data class OnPokeClick(val pokeId: Pokemon) : PokeListEvents()
    // Go to captured pokemon view via Poke Ball Click
    object onPokeBallClick : PokeListEvents()
}