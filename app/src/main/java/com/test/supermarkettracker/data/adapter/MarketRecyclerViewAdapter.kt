package com.test.supermarkettracker.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.supermarkettracker.data.model.MarketModel
import com.test.supermarkettracker.databinding.FragmentItemMarketBinding

class MarketRecyclerViewAdapter(
    private val clickListener: (MarketModel)->Unit
): RecyclerView.Adapter<MarketRecyclerViewHolder>() {

    private val markets = ArrayList<MarketModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketRecyclerViewHolder {
        val binding = FragmentItemMarketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MarketRecyclerViewHolder(binding)
    }

    override fun getItemCount() = markets.size

    override fun onBindViewHolder(holder: MarketRecyclerViewHolder, position: Int) {
        val market = markets[position]
        holder.bind(market, clickListener)
    }

    fun setData(marketList: List<MarketModel>){
        markets.clear()
        markets.addAll(marketList)
    }
}