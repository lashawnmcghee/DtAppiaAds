package com.lashawn.dtappiaads.viewmodels

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.lashawn.dtappiaads.models.Ad
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class SharedViewModelTest {
    private val instrumentationContext: Context = InstrumentationRegistry.getInstrumentation().context

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    //test that we get an empty add when we clear add
    @Test
    fun testWeGetAnEmptyAddWhenWeClearAdd() {
        val sut = SharedViewModel()
        val empty = Ad()
        sut.clearAd()
        assertThat(empty).isEqualTo(sut.ad.value)
    }

//    //test that we get the same ad we pass in to provideAd
//    @Test
//    fun testWeGetSameAdWePassInProvideAd() {
//        val sut = SharedViewModel()
//        val compareAd = Ad(productName = "TestAd")
//        sut.provideAd(compareAd)
//        assertThat(compareAd).isEqualTo(sut.ad.value)
//    }
//
//    //test that we are alerted when we provideAd
//    @Test
//    fun testWeGetAlertedWhenWeProvideAd() {
//        //TODO: Implement
//    }
//
//    //test that we are alerted when we provideAd and get back same Ad
//    @Test
//    fun testWeGetAlertedWithSameAdWhenWeProvideAd() {
//        //TODO: Implement
//    }
}