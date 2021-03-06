package com.ahrenswett.samaritanpokedex.data

import dagger.Provides
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

//      TODO: handle a bad address add validation to HTTPClient currently expects success

@OptIn(ExperimentalSerializationApi::class)
val PokeHttpClient : HttpClient by lazy { HttpClient(){
    Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
        explicitNulls = false
    }
} }