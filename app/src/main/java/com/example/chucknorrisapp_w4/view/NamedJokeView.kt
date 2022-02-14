package com.example.chucknorrisapp_w4.view

interface NamedJokeView {
    fun requestData()
    fun displayData(data : String) //presentation data
    fun showErrorMessage(error : String)
}