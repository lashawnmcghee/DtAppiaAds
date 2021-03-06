package com.lashawn.dtappiaads

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.lashawn.dtappiaads.common.Constants.DETAIL_TAG
import com.lashawn.dtappiaads.common.Constants.LIST_TAG
import com.lashawn.dtappiaads.viewmodels.SharedViewModel
import com.lashawn.dtappiaads.views.AdDetailFragment
import com.lashawn.dtappiaads.views.AdListFragment
import com.lashawn.dtappiaads.views.SplashFragment
import kotlinx.coroutines.delay
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * This is the one and only activity which controls fragments as different screens.
 */
class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.simpleName
    private val sharedViewModel: SharedViewModel by viewModel()
    private var backCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launchWhenStarted {
            showSplash()
            delay(2000)
            showAdList()
            sharedViewModel.ad.observe(this@MainActivity) {
                if(it.appId == null) {
                    showAdList()
                    Log.d(TAG, "Now Displaying List Fragment. ($backCount)")
                } else {
                    showAdDetail()
                    backCount++
                    Log.d(TAG, "Now Displaying Detail Fragment. ($backCount)")
                }
            }
        }
    }

    override fun onBackPressed() {
        if(--backCount > 0) {
            sharedViewModel.clearAd()
            Log.d(TAG, "Now clearing detail Ad. ($backCount)")
        } else {
            super.onBackPressed()
            Log.d(TAG, "Now exiting Main. ($backCount)")
        }
    }


    private fun showSplash() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flFragmentHolder, SplashFragment())
            .commit()
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
                .replace(R.id.flFragmentHolder, AdListFragment(), LIST_TAG)
                .commit()
        }
    }

    private fun showAdDetail() {
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