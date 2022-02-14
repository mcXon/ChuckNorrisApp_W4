package com.example.chucknorrisapp_w4.presenter

import com.example.chucknorrisapp_w4.model.remote.JokeResponse
import com.example.chucknorrisapp_w4.model.remote.Network
import com.example.chucknorrisapp_w4.view.NamedJokeView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterNamedJoke : IPresenterNamedJoke {

    private var _view : NamedJokeView? = null
    private val view : NamedJokeView
    get() = _view!!


    override fun bind(view: NamedJokeView) {
        _view = view
    }

    override fun unBind() {
        _view = null
    }

    override fun getNamedJoke(firstName: String, lastName: String) {
        Network.chuckAPI.getNamedJoke(firstName,lastName).enqueue(
            object : Callback<JokeResponse>{
                override fun onResponse(
                    call: Call<JokeResponse>,
                    response: Response<JokeResponse>,
                ) {
                    if(response.isSuccessful){
                        response.body()?.let {
                            view.displayData(it.value.joke)
                        }
                    }else{
                        view.showErrorMessage(response.message())
                    }
                }

                override fun onFailure(call: Call<JokeResponse>, t: Throwable) {
                    //Notify the view
                    //View display message
                    view.showErrorMessage(t.message ?: "Random error")
                }
            }
        )
    }
}