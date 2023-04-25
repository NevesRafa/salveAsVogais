package com.kansha.salveasvogais.presentation.home

import android.content.Intent
import android.graphics.drawable.AnimatedImageDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kansha.salveasvogais.databinding.ActivityHomeScreenBinding
import com.kansha.salveasvogais.presentation.route.RouteActivity

class HomeScreenActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpImage()
        clickStart()
    }

    fun clickStart() {
        binding.fabStart.setOnClickListener {
            val intent = Intent(this, RouteActivity::class.java)
            startActivity(intent)
        }
    }

    fun setUpImage() {
        val animation = binding.title.drawable as AnimatedImageDrawable
        animation.start()
    }
}