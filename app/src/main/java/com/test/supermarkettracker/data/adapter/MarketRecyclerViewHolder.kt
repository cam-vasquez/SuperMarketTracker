package com.test.supermarkettracker.data.adapter

import androidx.recyclerview.widget.RecyclerView
import com.test.supermarkettracker.data.model.MarketModel
import com.test.supermarkettracker.databinding.FragmentItemMarketBinding

class MarketRecyclerViewHolder(private val binding: FragmentItemMarketBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(
        market: MarketModel, clickListener: (MarketModel)->Unit
    ){
        binding.textViewName.text = market.name
        binding.textViewLocation.text = market.location
        binding.itemContainer.setOnClickListener{
            clickListener(market)
        }
    }
}