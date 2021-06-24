package com.example.basicmvi_hiltplayground.ui

import android.content.Context
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

//since with hilt the injection with nav components crash on rotation (on create problem)
@AndroidEntryPoint
class MainNavHostFragment: NavHostFragment() {

    @Inject
    lateinit var fragFactory: MainFragmentFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        childFragmentManager.fragmentFactory = fragFactory
    }
}