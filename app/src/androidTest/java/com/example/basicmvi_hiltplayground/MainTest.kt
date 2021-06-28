package com.example.basicmvi_hiltplayground

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@HiltAndroidTest
class MainTest {

    @get:Rule (order = 0) //u can order the rules
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init(){
        hiltRule.inject()
    }

    @Test
    fun someTest(){
        
    }
}