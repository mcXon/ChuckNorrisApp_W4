package com.example.chucknorrisapp_w4.model.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckAPI {
    @GET(END_POINT_SINGLE_JOKE)
    fun getSingleJoke(): Call<JokeResponse>

    @GET(END_POINT_SINGLE_JOKE)
    fun getNamedJoke(
        @Query(PARAM_FIRST) firstName : String,
        @Query(PARAM_LAST) lastName : String
    ): Call<JokeResponse>

}