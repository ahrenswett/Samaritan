package com.ahrenswett.samaritanpokedex.data

import com.ahrenswett.samaritanpokedex.data.api.Api
import com.ahrenswett.samaritanpokedex.domain.models.Pokemon
import com.ahrenswett.samaritanpokedex.domain.models.PokemonAddresses
import com.ahrenswett.samaritanpokedex.domain.models.Response
import com.ahrenswett.samaritanpokedex.util.Constants
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@ActivityScoped
class Repository @Inject constructor(
    private val api: Api
){
    var baseResponse: Response? = runBlocking { getPokemonListResponse(Constants.BASE_URL) }

    suspend fun getPokemonListResponse(url:String): Response {
//        TODO("Need to address passing the limit and offset")
        return api.loadPokeAddresses(url)}

    suspend fun getListItems(urls: List<PokemonAddresses>) : List<Pokemon>{
        val list: MutableList<Pokemon> = arrayListOf()
        urls.forEach { poke ->
            list.add (api.getListItem(poke.url))
        }
        return (list)
    }
}

