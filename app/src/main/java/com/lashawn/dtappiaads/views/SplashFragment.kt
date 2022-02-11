package com.lashawn.dtappiaads.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lashawn.dtappiaads.R

class SplashFragment : Fragment() {

    companion object {
        fun newInstance() = SplashFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(tag, "Splash screen showing.")
        return inflater.inflate(R.layout.splash_fragment, container, false)
    }
}