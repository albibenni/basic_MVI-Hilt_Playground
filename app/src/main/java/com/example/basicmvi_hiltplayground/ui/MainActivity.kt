package com.example.basicmvi_hiltplayground.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basicmvi_hiltplayground.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val TAG: String = "AppDebug"


    @Inject
    lateinit var fragmentFactory: MainFragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.fragmentFactory = fragmentFactory
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container, MainFragment::class.java, null)
            .commit()


    }




}