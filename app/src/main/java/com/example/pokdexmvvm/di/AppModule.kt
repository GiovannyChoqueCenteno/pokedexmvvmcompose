package com.example.pokdexmvvm.di

import com.example.pokdexmvvm.data.remote.PokeApi
import com.example.pokdexmvvm.repository.PokemonRepository
import com.example.pokdexmvvm.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providePokemonRepository(api: PokeApi) = PokemonRepository(api)


    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providePokeApi(retrofit: Retrofit): PokeApi {
        return retrofit.create(PokeApi::class.java)
    }
}