package com.test.supermarkettracker.ui.home.marketItem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.test.supermarkettracker.R
import com.test.supermarkettracker.data.model.MarketModel
import com.test.supermarkettracker.databinding.FragmentItemMarketBinding
import com.test.supermarkettracker.databinding.FragmentMarketDetailBinding
import com.test.supermarkettracker.ui.viewmodel.MarketViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [ItemMarketFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ItemMarketFragment : Fragment() {
    private lateinit var binding: FragmentItemMarketBinding
    private val marketViewModel: MarketViewModel by activityViewModels {
        MarketViewModel.Factory
    }
     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragmentItemMarketBinding.inflate(inflater, container, false)
         return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setMarketViewModel()
    }

    private fun setMarketViewModel(){
        binding.viewmodel = marketViewModel
    }

}