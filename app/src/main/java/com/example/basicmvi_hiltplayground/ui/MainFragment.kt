package com.example.basicmvi_hiltplayground.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.basicmvi_hiltplayground.R
import com.example.basicmvi_hiltplayground.model.Blog
import com.example.basicmvi_hiltplayground.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*
import java.lang.StringBuilder

@AndroidEntryPoint
class MainFragment
    constructor(
        private val someString: String
    ): Fragment(R.layout.fragment_main) {


    private val TAG = "AppDebug"

    private val viewModel: MainViewModel by viewModels() //kts dependency


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ${someString}")



        subscribeObservers()
        viewModel.setStateEvent(MainStateEvent.GetBlogEvents)
    }

    private fun subscribeObservers(){
        viewModel.dataState.observe(viewLifecycleOwner, Observer{ dataState ->

            when(dataState){
                is DataState.Success<List<Blog>> -> {
                    displayProgressBar(false)
                    appendBlogTitles(dataState.data)
                }
                is DataState.Error-> {
                    displayProgressBar(false)
                    displayError(dataState.exception.message)

                }
                is DataState.Loading -> {
                    displayProgressBar(true)

                }
            }

        })
    }

    private fun displayError(message: String?){
        if (message!= null)
            text.text = message
        else
            text.text = "Unknown error"
    }

    private fun displayProgressBar (isDisplayed: Boolean){
        progress_bar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }

    private fun appendBlogTitles(blogs: List<Blog>){
        val sb = StringBuilder()
        for (blog in blogs){
            sb.append(blog.title + "\n")
        }
        text.text = sb.toString()
    }

}