package com.kansha.salveasvogais.presentation.splash

import android.content.Intent
import android.graphics.drawable.AnimatedImageDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.kansha.salveasvogais.databinding.ActivitySplashScreenBinding
import com.kansha.salveasvogais.presentation.home.HomeScreenActivity

class SplashScreenActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpImage()
        splashScreenDuration()

    }

    fun splashScreenDuration() {
        val splashScreenDuration = 3000L // 3 segundos
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashScreenActivity, HomeScreenActivity::class.java)
            startActivity(intent)
            finish()
        }, splashScreenDuration)
    }

    fun setUpImage() {
        val animation = binding.kansha.drawable as AnimatedImageDrawable
        animation.start()
    }
}