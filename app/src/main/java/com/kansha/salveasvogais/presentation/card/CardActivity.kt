package com.kansha.salveasvogais.presentation.card

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kansha.salveasvogais.data.model.WordDetails
import com.kansha.salveasvogais.databinding.ActivityWordBinding
import org.koin.android.ext.android.inject

class CardActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_CARD_DETAILS = "extra_card_details"
    }

    private val viewModel: CardViewModel by inject()
    lateinit var binding: ActivityWordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservers()

        intent.getParcelableExtra<WordDetails>(EXTRA_CARD_DETAILS)?.let {
            loadCardDetails(it)
        }
    }

    private fun setupObservers() {
        viewModel.wordLiveData.observe(this) { state ->
            when (state) {
                is CardState.Loading -> {}
                is CardState.Success -> state.result?.let { loadCardDetails(it) }
                is CardState.Error -> {}
            }
        }
    }

    private fun loadCardDetails(cardDetails: WordDetails) {
        binding.word.text = cardDetails.word
        cardDetails.image?.let { binding.animationView.setAnimation(it) }
    }
}