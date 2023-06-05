package com.test.supermarkettracker.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.supermarkettracker.R
import com.test.supermarkettracker.data.adapter.MarketRecyclerViewAdapter
import com.test.supermarkettracker.data.model.MarketModel
import com.test.supermarkettracker.databinding.FragmentHomeBinding
import com.test.supermarkettracker.ui.viewmodel.MarketViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: MarketRecyclerViewAdapter
    private val marketViewModel: MarketViewModel by activityViewModels {
        MarketViewModel.Factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        })

        appListeners()
        marketRecyclerView(view)
    }

    private fun marketRecyclerView(view: View){
        binding.recyclerMarket.layoutManager = LinearLayoutManager(view.context)
        adapter = MarketRecyclerViewAdapter {
            selectedMarket -> showSelectedMarket(selectedMarket)
        }

        binding.recyclerMarket.adapter = adapter
        displayAllMarkets()
    }

    private fun displayAllMarkets(){
        adapter.setData(marketList = marketViewModel.getMarkets())
        adapter.notifyDataSetChanged()
    }

    private fun showSelectedMarket(selectedMarket: MarketModel){
        marketViewModel.setSelectedMarket(selectedMarket)

        findNavController().navigate(R.id.action_homeFragment_to_marketDetailFragment)
    }

    private fun appListeners(){
        binding.floatingActionButtonAdd.setOnClickListener{
            marketViewModel.clearData()

            it.findNavController().navigate(R.id.action_homeFragment_to_newMarketFragment)
        }
    }
    private fun onBackPressed(){
        val navController = Navigation.findNavController(requireView())

        if(navController.currentDestination?.id != R.id.homeFragment){
            navController.popBackStack()
        }
        else requireActivity().onBackPressed()
    }
}