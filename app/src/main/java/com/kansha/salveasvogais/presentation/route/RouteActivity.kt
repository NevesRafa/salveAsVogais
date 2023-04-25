package com.kansha.salveasvogais.presentation.route

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kansha.salveasvogais.databinding.ActivityRouteBinding

class RouteActivity : AppCompatActivity() {

    lateinit var binding: ActivityRouteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRouteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}