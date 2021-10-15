package com.reisdeveloper.cryptocurrencymvvm.presenter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.reisdeveloper.cryptocurrencymvvm.databinding.FragmentLiveCurrenciesBinding
import com.reisdeveloper.cryptocurrencymvvm.domain.model.LiveCurrencies
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class LiveCurrenciesFragment : Fragment() {

    private val viewModel: LiveCurrenciesViewModel by sharedViewModel()

    private lateinit var binding: FragmentLiveCurrenciesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLiveCurrenciesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fragment = this

        viewModel.currencies.observe( viewLifecycleOwner, Observer { listCategoryUiModel ->
            populateMealsCategory(listCategoryUiModel)
        })
    }

    fun getLiveCurrencies() {
        viewModel.getLiveCurrencies()
    }

    private fun populateMealsCategory(currencies: LiveCurrencies) {
        var rates = ""
        currencies.rates.forEach {
            rates += "${it.first} : ${it.second}"
        }
    }

}