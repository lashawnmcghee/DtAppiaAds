package com.lashawn.dtappiaads.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.lashawn.dtappiaads.getOrAwaitValue
import com.lashawn.dtappiaads.models.Ad
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class AdListViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var sut: AdListViewModel

    @Before
    fun setUp() {
        sut = AdListViewModel()
    }

    @After
    fun tearDown() {
    }

    //ensure we have adds on init
    @Test
    fun testWeGetAdsOnInit() = runTest {
        val result = sut.ads.getOrAwaitValue()
        assertThat(result).isNotEmpty()
    }

    //test errorMessage
//    @Test
//    fun testWeGetExpectedErrorMessage() = runTest {
//        val error = "Some error message."
//        val result = sut.errorMessage.getOrAwaitValue()
//        assertThat(result).isEqualTo(error)
//    }

    //test ads and contents
//    @Test
//    fun testWeGetAlertAndEmptyAdWhenWeClearAd() = runTest {
//        val expectedAds = mutableListOf<Ad>()
//        sut.refreshAds()
//        val result = sut.ads.getOrAwaitValue()
//        assertThat(result).isEqualTo(expectedAds)
//    }
}