package com.example.chucknorrisapp_w4.view

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.chucknorrisapp_w4.databinding.NamedJokeFragmentLayoutBinding
import com.example.chucknorrisapp_w4.presenter.IPresenterNamedJoke
import com.example.chucknorrisapp_w4.presenter.PresenterNamedJoke
import com.google.android.material.snackbar.Snackbar

class NamedJokeFragment: Fragment(), NamedJokeView {

    private val presenter : IPresenterNamedJoke by lazy {
        PresenterNamedJoke()
    }

    private lateinit var binding : NamedJokeFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = NamedJokeFragmentLayoutBinding.inflate(inflater, container,false)
        presenter.bind(this)
        binding.btnGetJoke.setOnClickListener {

        }

        return binding.root
    }

    override fun requestData() {
        presenter.getNamedJoke(
            binding.etNamedFirstName.text.toString(),
            binding.etNamedLastName.text.toString()
        )
    }

    override fun displayData(data: String) {
        //display dialog
        AlertDialog.Builder(requireContext())
            .setTitle("Some some")
            .setMessage(data)
            .setPositiveButton("Was fun", DialogInterface.OnClickListener{dialog, pos ->
                dialog.dismiss()
            }).show()
    }

    override fun showErrorMessage(error : String) {
        AlertDialog.Builder(requireContext())
            .setTitle(error)
            .setMessage(error)
            .show()
    }
}