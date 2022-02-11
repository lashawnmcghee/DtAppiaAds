package com.lashawn.dtappiaads.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.lashawn.dtappiaads.databinding.AdListFragmentBinding
import com.lashawn.dtappiaads.models.Ad
import com.lashawn.dtappiaads.viewmodels.AdListViewModel
import com.lashawn.dtappiaads.viewmodels.SharedViewModel
import com.lashawn.dtappiaads.views.adapters.DataBindingRecyclerAdapter
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class AdListFragment : Fragment() {
    companion object {
        fun newInstance() = AdListFragment()
    }

    private lateinit var adapter: DataBindingRecyclerAdapter
    private val viewModel: AdListViewModel by inject()
    private val sharedViewModel: SharedViewModel by sharedViewModel()

    private var _binding: AdListFragmentBinding? = null
    private val binding: AdListFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AdListFragmentBinding.inflate(inflater, container, false)

        lifecycleScope.launchWhenStarted {
            setupViewItems()
            subscribeToObservables()
            Log.d(tag, "Ad list prepared and observing for updates.")
        }

        return binding.root
    }

    /**
     * Set up view items.
     * Note: This method must be run before subscribing to observables.
     */
    private fun setupViewItems() {
        val onAdClicked: (clickedAd: Ad) -> Unit = { clickedAd ->
            sharedViewModel.provideAd(clickedAd)
        }
        adapter = DataBindingRecyclerAdapter(onAdClicked)
        binding.rvAds.adapter = adapter

        binding.swpRefresh.setOnRefreshListener {
            viewModel.refreshAds()
            binding.swpRefresh.isRefreshing = false
        }
    }

    /**
     * You must set up your view items before running this method
     */
    private fun subscribeToObservables() {
        viewModel.ads.observe(viewLifecycleOwner) {
            adapter.setAdsList(it)
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            Snackbar.make(
                binding.root,
                it,
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }
}