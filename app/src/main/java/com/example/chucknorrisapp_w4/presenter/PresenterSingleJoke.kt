package com.example.chucknorrisapp_w4.presenter

import com.example.chucknorrisapp_w4.model.remote.JokeResponse
import com.example.chucknorrisapp_w4.model.remote.Network
import com.example.chucknorrisapp_w4.model.remote.ValueItem
import com.example.chucknorrisapp_w4.view.SingleJokeView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterSingleJoke : IPresenterSingleJoke {

    private var view : SingleJokeView? = null // Nullable in order to dispose in the unbind

    override fun bind(view: SingleJokeView) {
        this.view = view
    }

    override fun unBind() {
        view = null
    }

    override fun getSingleJoke() {
        Network.chuckAPI.getSingleJoke().enqueue(
            object : Callback<JokeResponse>{
                override fun onResponse(call: Call<JokeResponse>, response: Response<JokeResponse>) {
                    if(response.isSuccessful){
                        response.body()?.let {
                            view?.displayData(it.value.joke)
                        }
                    }
                }

                override fun onFailure(call: Call<JokeResponse>, t: Throwable) {
                    view?.showErrorMessage(t.message ?: "Random error message")
                }
            }
        )
    }
}