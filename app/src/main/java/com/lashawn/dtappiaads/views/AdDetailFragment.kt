package com.lashawn.dtappiaads.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import coil.load
import coil.transform.RoundedCornersTransformation
import com.lashawn.dtappiaads.R
import com.lashawn.dtappiaads.databinding.AdDetailFragmentBinding
import com.lashawn.dtappiaads.viewmodels.SharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class AdDetailFragment : Fragment() {

    companion object {
        fun newInstance() = AdDetailFragment()
    }

    private val sharedViewModel: SharedViewModel by sharedViewModel()

    private var _binding: AdDetailFragmentBinding? = null
    private val binding: AdDetailFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AdDetailFragmentBinding.inflate(inflater, container, false)

        lifecycleScope.launchWhenStarted {
            sharedViewModel.ad.observe(viewLifecycleOwner) {
                binding.ad = it;

                binding.ivProductPhoto.load(it.productThumbnail) {
                    crossfade(true)
                    placeholder(R.drawable.ic_baseline_cloud_download_24)
                    error(R.drawable.ic_baseline_error_outline_24)
                    transformations(RoundedCornersTransformation(10f))
                }
            }
            Log.d(tag, "Ad details now showing.")
        }

         return binding.root
    }
}