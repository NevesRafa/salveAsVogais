package com.kansha.salveasvogais.presentation.route

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kansha.salveasvogais.data.model.WordDetails
import com.kansha.salveasvogais.databinding.ItemCardBinding

class RouteAdapter : RecyclerView.Adapter<WordViewHolder>() {

    private val dataset = mutableListOf<WordDetails>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCardBinding.inflate(inflater, parent, false)
        return WordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount() = dataset.size

    fun update(list: List<WordDetails>) {
        this.dataset.clear()
        this.dataset.addAll(list)
        notifyDataSetChanged()
    }
}

class WordViewHolder(private val binding: ItemCardBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(word: WordDetails) {
        binding.cardNumber.text = word.id.toString()
    }
}
