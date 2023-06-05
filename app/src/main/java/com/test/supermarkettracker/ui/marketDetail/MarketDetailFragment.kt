package com.test.supermarkettracker.ui.marketDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.test.supermarkettracker.R
import com.test.supermarkettracker.data.model.MarketModel
import com.test.supermarkettracker.databinding.FragmentMarketDetailBinding
import com.test.supermarkettracker.ui.viewmodel.MarketViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [MarketDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MarketDetailFragment : Fragment() {
    private lateinit var binding: FragmentMarketDetailBinding
    private val marketViewModel: MarketViewModel by activityViewModels {
        MarketViewModel.Factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMarketDetailBinding.inflate(inflater, container, false)
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