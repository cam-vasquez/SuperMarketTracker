package com.test.supermarkettracker.repository

import com.test.supermarkettracker.data.model.MarketModel

class Repository (private val markets: MutableList<MarketModel>) {
    fun getMarkets () = markets

    fun setMarket (market: MarketModel) = markets.add(market)

}