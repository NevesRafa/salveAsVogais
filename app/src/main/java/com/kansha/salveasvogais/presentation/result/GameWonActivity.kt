package com.kansha.salveasvogais.presentation.result

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kansha.salveasvogais.R
import com.kansha.salveasvogais.databinding.ActivityGameWonBinding

class GameWonActivity : AppCompatActivity() {

    lateinit var binding: ActivityGameWonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameWonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupGameWon()
    }

    fun setupGameWon() {
        binding.animationViewWin.setAnimation(R.raw.win)
        binding.animationViewTreasure.setAnimation(R.raw.treasure)
    }
}