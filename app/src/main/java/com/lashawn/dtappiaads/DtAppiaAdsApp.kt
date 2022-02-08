package com.lashawn.dtappiaads

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DtAppiaAdsApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DtAppiaAdsApp)
            modules(listOf(appModule, viewModel))
        }
    }
}