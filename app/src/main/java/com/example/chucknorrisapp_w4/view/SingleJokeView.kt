package com.example.chucknorrisapp_w4.view

import com.example.chucknorrisapp_w4.model.remote.JokeResponse

interface SingleJokeView {
    fun requestData()
    fun displayData(data : String) //presentation data
    fun showErrorMessage(errorMessage: String)
}