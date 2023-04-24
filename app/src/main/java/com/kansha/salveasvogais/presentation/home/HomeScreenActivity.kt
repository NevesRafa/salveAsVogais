package com.kansha.salveasvogais.presentation.home

import android.graphics.drawable.AnimatedImageDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kansha.salveasvogais.databinding.ActivityHomeScreenBinding

class HomeScreenActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpImage()
    }

    fun setUpImage() {
        val animation = binding.title.drawable as AnimatedImageDrawable
        animation.start()
    }
}