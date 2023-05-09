package com.kansha.salveasvogais.presentation.card

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kansha.salveasvogais.data.model.WordDetails
import com.kansha.salveasvogais.databinding.ActivityWordBinding
import com.kansha.salveasvogais.presentation.result.GameWonActivity
import com.kansha.salveasvogais.presentation.result.LostGameActivity
import org.koin.android.ext.android.inject

class CardActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_CARD_DETAILS = "extra_card_details"
    }

    private val viewModel: CardViewModel by inject()
    private lateinit var binding: ActivityWordBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservers()
        setupFab()
        setupBackButton()
        setupClearButton()
        setupConfirmButton()

        intent.getParcelableExtra<WordDetails>(EXTRA_CARD_DETAILS)?.let {
            viewModel.initGame(it)
        }

    }

    private fun setupObservers() {
        viewModel.cardLiveData.observe(this) { state ->
            when (state) {
                is CardState.InitGame -> setupGame(state)
                is CardState.UpdateWord -> setupUpdateWord(state)
                is CardState.GameWon -> showGameResultWon()
                is CardState.LostGame -> showGameResultLost()
            }
        }
    }

    private fun setupUpdateWord(state: CardState.UpdateWord) {
        binding.word.text = state.word
    }

    private fun setupGame(state: CardState.InitGame) {
        binding.word.text = state.word
        binding.animationView.setAnimation(state.image)
    }

    private fun setupFab() {
        binding.letterA.setOnClickListener {
            viewModel.updateWordWithoutVowel("A")
        }

        binding.letterE.setOnClickListener {
            viewModel.updateWordWithoutVowel("E")
        }

        binding.letterI.setOnClickListener {
            viewModel.updateWordWithoutVowel("I")
        }

        binding.letterO.setOnClickListener {
            viewModel.updateWordWithoutVowel("O")
        }

        binding.letterU.setOnClickListener {
            viewModel.updateWordWithoutVowel("U")
        }
    }

    private fun setupBackButton() {
        binding.backButton.setOnClickListener { finish() }
    }

    private fun setupClearButton() {
        binding.clear.setOnClickListener {
            viewModel.loadCardDetails()
        }
    }

    private fun setupConfirmButton() {
        binding.confirm.setOnClickListener {
            viewModel.checkWord()
        }
    }

    private fun showGameResultWon() {
        val intent = Intent(this, GameWonActivity::class.java)
        startActivity(intent)
    }

    private fun showGameResultLost() {
        val intent = Intent(this, LostGameActivity::class.java)
        startActivity(intent)
    }

}