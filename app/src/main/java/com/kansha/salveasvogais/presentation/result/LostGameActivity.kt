package com.kansha.salveasvogais.presentation.result

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kansha.salveasvogais.R
import com.kansha.salveasvogais.databinding.ActivityLostGameBinding

class LostGameActivity : AppCompatActivity() {

    lateinit var binding: ActivityLostGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLostGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupLostGame()
    }

    fun setupLostGame() {
        binding.animationViewLost.setAnimation(R.raw.lost)

        binding.tryAgain.setOnClickListener {
            finish()
        }
    }
}