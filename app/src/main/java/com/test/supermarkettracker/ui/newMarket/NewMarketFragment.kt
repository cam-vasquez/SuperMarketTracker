package com.test.supermarkettracker.ui.newMarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setMarketViewModel()
        setMarketStatus()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewMarketBinding.inflate(inflater, container, false)
        return binding.root
       }

    private fun setMarketStatus(){
        marketViewModel.status.observe(viewLifecycleOwner){
            status->
            when{
                status.equals(MarketViewModel.WRONG_FIELDS) ->{
                    val toast = Toast.makeText(requireContext(), MarketViewModel.WRONG_FIELDS, Toast.LENGTH_SHORT)
                    toast.show()
                }
                status.equals(MarketViewModel.MARKET_ADDED) ->{
                    val toast = Toast.makeText(requireContext(), MarketViewModel.MARKET_ADDED, Toast.LENGTH_SHORT)
                    toast.show()
                    marketViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    private fun setMarketViewModel(){
        binding.viewmodel = marketViewModel
    }
}