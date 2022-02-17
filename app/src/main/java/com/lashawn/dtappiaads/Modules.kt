package com.lashawn.dtappiaads

import androidx.lifecycle.MutableLiveData
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.lashawn.dtappiaads.models.Ad
import com.lashawn.dtappiaads.models.AdsRequest
import com.lashawn.dtappiaads.networking.AdRepositoryImpl
import com.lashawn.dtappiaads.viewmodels.AdListViewModel
import com.lashawn.dtappiaads.viewmodels.SharedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel


import org.koin.core.module.Module
import org.koin.dsl.module
import javax.xml.stream.XMLInputFactory
import javax.xml.stream.XMLOutputFactory

val appModule : Module = module {
    single { AdRepositoryImpl() }
    single { AdsRequest(MutableLiveData<List<Ad>>(), MutableLiveData<String>()) }
    single { XmlMapper(XMLInputFactory.newInstance(), XMLOutputFactory.newInstance()) }
}

val viewModel : Module = module {
    viewModel { AdListViewModel() }
    viewModel { SharedViewModel() }
}