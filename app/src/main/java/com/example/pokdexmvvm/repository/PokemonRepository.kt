package com.example.pokdexmvvm.repository

import com.example.pokdexmvvm.data.remote.PokeApi
import com.example.pokdexmvvm.data.remote.responses.Pokemon
import com.example.pokdexmvvm.data.remote.responses.PokemonList
import com.example.pokdexmvvm.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("Error al obtener")
        }
        return Resource.Success<PokemonList>(response)
    }

    suspend fun getPokemonInfo(pokeName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokeName)
        } catch (e: Exception) {
            return Resource.Error("Error al obtener")
        }
        return Resource.Success<Pokemon>(response)
    }

}