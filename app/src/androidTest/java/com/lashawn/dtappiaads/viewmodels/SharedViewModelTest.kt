package com.lashawn.dtappiaads.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.lashawn.dtappiaads.getOrAwaitValue
import com.lashawn.dtappiaads.models.Ad
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class SharedViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var sut: SharedViewModel

    @Before
    fun setUp() {
        sut = SharedViewModel()
    }

    @After
    fun tearDown() {
    }

    //test that we get an empty add when we clear add
    @Test
    fun testWeGetAlertAndEmptyAdWhenWeClearAd() = runTest {
        val emptyAd = Ad()
        sut.clearAd()
        val result = sut.ad.getOrAwaitValue()
        assertThat(emptyAd).isEqualTo(result)
    }

    //test that we get the same ad we pass in to provideAd
    @Test
    fun testWeGetAlertAndSameAdWePassInProvideAd() = runTest {
        val compareAd = Ad(productName = "TestAd")
        sut.provideAd(compareAd)
        val result = sut.ad.getOrAwaitValue()
        assertThat(compareAd).isEqualTo(result)
    }
}