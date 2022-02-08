package com.lashawn.dtappiaads.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.lashawn.dtappiaads.views.adapters.DataBindingRecyclerAdapter
import com.lashawn.dtappiaads.databinding.AdListFragmentBinding
import com.lashawn.dtappiaads.models.Ad
import com.lashawn.dtappiaads.viewmodels.AdListViewModel
import com.lashawn.dtappiaads.viewmodels.SharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AdListFragment : Fragment() {
    companion object {
        fun newInstance() = AdListFragment()
    }

    private var lastHash:Int = 0
    private lateinit var adapter: DataBindingRecyclerAdapter
    private val viewModel: AdListViewModel by viewModel()
    private val sharedViewModel: SharedViewModel by sharedViewModel()

    private var _binding: AdListFragmentBinding? = null
    private val binding: AdListFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AdListFragmentBinding.inflate(inflater, container, false)

        val onAdClicked: (clickedAd: Ad) -> Unit = { clickedAd ->
            sharedViewModel.provideAd(clickedAd)
        }

        adapter = DataBindingRecyclerAdapter(onAdClicked)
        binding.rvAds.adapter = adapter

        lifecycleScope.launchWhenStarted {
            viewModel.ads.observe(viewLifecycleOwner) {
                val newHash = it.hashCode()
                if (lastHash != newHash) {
                    adapter.setAdsList(it)
                    lastHash = newHash
                }
            }

            binding.swpRefresh.setOnRefreshListener {
                viewModel.refreshAds()
                binding.swpRefresh.isRefreshing = false
            }
        }

        return binding.root
    }
}