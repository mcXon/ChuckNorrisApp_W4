package com.example.chucknorrisapp_w4.presenter

import com.example.chucknorrisapp_w4.view.SingleJokeView

interface IPresenterSingleJoke {
    fun bind(view : SingleJokeView)
    fun unBind() // Dispose the bind due to ConfigChanges ()
    fun getSingleJoke()
}