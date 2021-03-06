package com.ahrenswett.samaritanpokedex.domain.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json


val responseFormat = Json { coerceInputValues = true }

@Serializable
data class Response(
    val count : Int,
    val next : String?,
    val previous : String?,
    val results : List<PokemonAddresses>
)

fun decodeResponse(response : String) : Response {
    return responseFormat.decodeFromString(Response.serializer(), response)
}
