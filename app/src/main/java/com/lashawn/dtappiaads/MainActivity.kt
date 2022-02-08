package com.lashawn.dtappiaads

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.lashawn.dtappiaads.viewmodels.SharedViewModel
import com.lashawn.dtappiaads.views.AdDetailFragment
import com.lashawn.dtappiaads.views.AdListFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val sharedViewModel: SharedViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showAdList()

        lifecycleScope.launchWhenStarted {
            sharedViewModel.ad.observe(this@MainActivity) {
                showAdDetail()
            }
        }
    }

    private fun showAdList() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flFragmentHolder, AdListFragment())
            .commit()
    }

    private fun showAdDetail() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.flFragmentHolder, AdDetailFragment()).commit()
    }
}