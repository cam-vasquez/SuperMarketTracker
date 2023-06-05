package com.test.supermarkettracker

import android.app.Application
import com.test.supermarkettracker.data.model.markets
import com.test.supermarkettracker.repository.Repository

class MarketReviewerApp: Application() {
    val marketRepository: Repository by lazy {
        Repository(markets)
    }
}