package com.example.chucknorrisapp_w4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.chucknorrisapp_w4.databinding.ActivityMainBinding
import com.example.chucknorrisapp_w4.view.NamedJokeFragment
import com.example.chucknorrisapp_w4.view.SingleJokeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ibSingle.setOnClickListener { inflateFragment(binding.ibSingle) }

        binding.ibNamed.setOnClickListener { inflateFragment(binding.ibNamed) }


    }

    private fun inflateFragment(view : View){
        when (view.id){
            R.id.ib_single -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fc_container, SingleJokeFragment())
                    .addToBackStack(null)
                    .commit()
            }
            R.id.ib_named -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fc_container, NamedJokeFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}