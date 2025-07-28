package com.example.feedviewerapp.data.remote

import com.example.feedviewerapp.data.model.CharacterResponse
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    suspend fun getCharacters(): CharacterResponse
}