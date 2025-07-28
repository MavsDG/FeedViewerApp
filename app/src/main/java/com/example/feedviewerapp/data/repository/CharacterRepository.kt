package com.example.feedviewerapp.data.repository

import androidx.lifecycle.LiveData
import com.example.feedviewerapp.data.local.CharacterDao
import com.example.feedviewerapp.data.local.CharacterEntity
import com.example.feedviewerapp.data.remote.RetrofitInstance

class CharacterRepository(private val dao: CharacterDao) {

    // Fetch from network using Retrofit
    suspend fun fetchCharactersFromNetwork(): List<CharacterEntity> {
        val response = RetrofitInstance.api.getCharacters()
        return response.results.map {
            CharacterEntity(
                id = it.id,
                name = it.name,
                status = it.status,
                species = it.species,
                image = it.image
            )
        }
    }

    // Save to Room
    suspend fun saveCharactersToDb(characters: List<CharacterEntity>) {
        dao.insertAll(characters)
    }

    // Load from Room
    fun getCharactersFromDb(): LiveData<List<CharacterEntity>> {
        return dao.getAll()
    }

}