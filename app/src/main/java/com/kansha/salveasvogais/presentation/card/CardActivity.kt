package com.kansha.salveasvogais.presentation.card

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kansha.salveasvogais.data.model.WordDetails
import com.kansha.salveasvogais.databinding.ActivityWordBinding
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
                is CardState.GameWon -> showGameResult("DEu Certo")
                is CardState.LostGame -> showGameResult("DEu Ruim")
                is CardState.Error -> {}
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

    private fun showGameResult(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}