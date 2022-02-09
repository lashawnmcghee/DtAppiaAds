package com.lashawn.dtappiaads

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.lashawn.dtappiaads.common.Constants.DETAIL_TAG
import com.lashawn.dtappiaads.common.Constants.LIST_TAG
import com.lashawn.dtappiaads.models.Ad
import com.lashawn.dtappiaads.viewmodels.SharedViewModel
import com.lashawn.dtappiaads.views.AdDetailFragment
import com.lashawn.dtappiaads.views.AdListFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val sharedViewModel: SharedViewModel by viewModel()
    private var backCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showAdList()

        lifecycleScope.launchWhenStarted {
            sharedViewModel.ad.observe(this@MainActivity) {
                if(it.appId == null) {
                    showAdList()
                } else {
                    showAdDetail()
                    backCount++
                }
            }
        }
    }

    override fun onBackPressed() {
        if(--backCount > 0) {
            sharedViewModel.clearAd()
        } else {
            super.onBackPressed()
        }
    }

    private fun showAdList() {
        val listFrag: Fragment? = supportFragmentManager.findFragmentByTag(LIST_TAG)

        if (listFrag != null)  {
            val detailFrag: Fragment? = supportFragmentManager.findFragmentByTag(DETAIL_TAG)
            supportFragmentManager.beginTransaction()
                .hide(detailFrag!!)
                .show(listFrag)
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .add(R.id.flFragmentHolder, AdListFragment(), LIST_TAG)
                .commit()
        }
    }

    private fun showAdDetail() {
//        supportFragmentManager.beginTransaction()
//            .addToBackStack(null)
//            .replace(R.id.flFragmentHolder, AdDetailFragment()).commit()
        val listFrag: Fragment? = supportFragmentManager.findFragmentByTag(LIST_TAG)
        val detailFrag: Fragment? = supportFragmentManager.findFragmentByTag(DETAIL_TAG)

        if (detailFrag != null)  {
            supportFragmentManager.beginTransaction()
                .hide(listFrag!!)
                .show(detailFrag)
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .hide(listFrag!!)
                .add(R.id.flFragmentHolder, AdDetailFragment(), DETAIL_TAG)
                .commit()
        }
    }
}