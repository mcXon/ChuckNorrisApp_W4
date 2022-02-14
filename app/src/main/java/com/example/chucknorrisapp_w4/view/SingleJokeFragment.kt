package com.example.chucknorrisapp_w4.view

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chucknorrisapp_w4.databinding.SingleJokeLayoutFragmentBinding
import com.example.chucknorrisapp_w4.presenter.IPresenterSingleJoke
import com.example.chucknorrisapp_w4.presenter.PresenterSingleJoke

class SingleJokeFragment: Fragment(), SingleJokeView {

    private val presenter : IPresenterSingleJoke by lazy {
        PresenterSingleJoke()
    }
    private var _binding : SingleJokeLayoutFragmentBinding? = null
    private val binding: SingleJokeLayoutFragmentBinding
    get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = SingleJokeLayoutFragmentBinding.inflate(inflater, container,false)

        presenter.bind(this)
        requestData()
        return binding.root
    }

    override fun requestData() {
        presenter.getSingleJoke()
    }

    override fun displayData(data: String) {
        binding.tvSingleJoke.text = data
    }

    override fun showErrorMessage(errorMessage: String) {
        AlertDialog.Builder(requireContext())
            .setTitle(errorMessage)
            .setMessage(errorMessage)
            .show()
    }

    override fun onStop() {
        super.onStop()
        presenter.unBind()
    }
}