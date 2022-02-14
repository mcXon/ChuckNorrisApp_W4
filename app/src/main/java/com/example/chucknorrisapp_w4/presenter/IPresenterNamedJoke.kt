package com.example.chucknorrisapp_w4.presenter

import com.example.chucknorrisapp_w4.view.NamedJokeView

interface IPresenterNamedJoke {
    fun bind(view : NamedJokeView)
    fun unBind() // Dispose the bind due to ConfigChanges ()
    fun getNamedJoke(firstName : String, lastName : String)
}