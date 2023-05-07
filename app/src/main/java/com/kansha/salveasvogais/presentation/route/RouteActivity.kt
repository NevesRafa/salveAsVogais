package com.kansha.salveasvogais.presentation.route

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.kansha.salveasvogais.data.model.WordDetails
import com.kansha.salveasvogais.databinding.ActivityRouteBinding
import com.kansha.salveasvogais.presentation.card.CardActivity
import org.koin.android.ext.android.inject

class RouteActivity : AppCompatActivity() {

    private val viewModel: RouteViewModel by inject()
    lateinit var binding: ActivityRouteBinding
    lateinit var routeAdapter: RouteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRouteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupList()
        setupObservers()

        viewModel.loadWordList()
    }

    private fun setupObservers() {
        viewModel.loadStateLiveData.observe(this) { state ->
            when (state) {
                is RouteState.Loading -> {}
                is RouteState.Success -> showResponse(state.result)
                is RouteState.Error -> {}
            }
        }
    }

    private fun showResponse(result: List<WordDetails>) {
        routeAdapter.update(result)
    }

    private fun setupList() {
        routeAdapter = RouteAdapter { card ->
            val intent = Intent(this, CardActivity::class.java)
            intent.putExtra(CardActivity.EXTRA_CARD_DETAILS, card)
            startActivity(intent)
        }

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager =
                GridLayoutManager(this@RouteActivity, 4, GridLayoutManager.VERTICAL, false)
            adapter = this@RouteActivity.routeAdapter
        }
    }
}