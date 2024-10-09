package com.example.dictionary

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val Base_URL= "https://api.dictionaryapi.dev/api/v2/entries/"
    private fun getInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val dictionaryApi : DictionaryApi = getInstance().create(DictionaryApi::class.java)
}