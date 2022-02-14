package com.example.chucknorrisapp_w4.model.remote

data class JokeResponse(
    val value :  ValueItem
)

data class ValueItem(
    val id : Int,
    val joke : String,
    val categories: List<String>
)
