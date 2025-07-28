package com.example.feedviewerapp.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.feedviewerapp.data.local.CharacterDatabase
import com.example.feedviewerapp.data.local.CharacterEntity
import com.example.feedviewerapp.data.repository.CharacterRepository
import kotlinx.coroutines.launch

class CharacterViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CharacterRepository
    val characters: LiveData<List<CharacterEntity>>

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    init {
        val dao = CharacterDatabase.getDatabase(application).characterDao()
        repository = CharacterRepository(dao)
        characters = repository.getCharactersFromDb()

        refreshCharacters()
    }

    private fun refreshCharacters() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val fromApi = repository.fetchCharactersFromNetwork()
                repository.saveCharactersToDb(fromApi)
            } catch (e: Exception) {

            }
            _isLoading.value = false
        }
    }
}