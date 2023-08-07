package com.example.pokdexmvvm.pokemondetail

import androidx.lifecycle.ViewModel
import com.example.pokdexmvvm.data.remote.responses.Pokemon
import com.example.pokdexmvvm.repository.PokemonRepository
import com.example.pokdexmvvm.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {
    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}