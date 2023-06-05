package com.test.supermarkettracker.ui.newMarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.test.supermarkettracker.R
import com.test.supermarkettracker.data.model.MarketModel
import com.test.supermarkettracker.databinding.FragmentNewMarketBinding
import com.test.supermarkettracker.ui.viewmodel.MarketViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [NewMarketFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewMarketFragment : Fragment() {
    private lateinit var binding: FragmentNewMarketBinding
    private val marketViewModel: MarketViewModel by activityViewModels {
        MarketViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewMarketBinding.inflate(inflater, container, false)
        return binding.root
       }
}