package com.example.chucknorrisapp_w4.model.remote

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object Network {

    val chuckAPI : ChuckAPI by lazy {
        initRetrofit().create(ChuckAPI::class.java)
    }

    private fun initRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}