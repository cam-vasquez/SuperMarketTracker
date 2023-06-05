package com.test.supermarkettracker.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.test.supermarkettracker.MarketReviewerApp
import com.test.supermarkettracker.data.model.MarketModel
import com.test.supermarkettracker.repository.Repository

class MarketViewModel(private val repository: Repository): ViewModel() {

    val name = MutableLiveData("")
    val location = MutableLiveData("")
    val status = MutableLiveData("")

    fun getMarkets()= repository.getMarkets()

    private fun addMarket(market: MarketModel)= repository.setMarket(market)

    private fun validateData(): Boolean{
        when{
            name.value.isNullOrBlank() -> return  false
            location.value.isNullOrBlank() -> return  false
        }
        return true
    }

    fun createMarket(): String{
        if(!validateData()){
            status.value = WRONG_FIELDS
            return WRONG_FIELDS
        }

        val market = MarketModel(
            name = name.value!!,
            location = location.value!!
        )

        addMarket(market)
        status.value = MARKET_ADDED
        return MARKET_ADDED
    }

    fun clearData(){
        name.value = ""
        location.value = ""
    }

    fun clearStatus(){
        status.value = INACTIVE
    }

    fun selectedMarket(market: MarketModel){
        name.value = market.name
        location.value = market.location
    }

    companion object{

        val Factory = viewModelFactory {
            initializer {
                val marketRepository = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MarketReviewerApp).marketRepository
                MarketViewModel(marketRepository)
            }
        }

        const val MARKET_ADDED = "market added successfully!"
        const val WRONG_FIELDS = "wrong fields information"
        const val INACTIVE = ""

    }
}