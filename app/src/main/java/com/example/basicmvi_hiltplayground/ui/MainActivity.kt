package com.example.basicmvi_hiltplayground.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basicmvi_hiltplayground.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint //still needed with the hosts
class MainActivity : AppCompatActivity() {


    private val TAG: String = "AppDebug"


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }




}