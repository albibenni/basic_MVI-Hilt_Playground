package com.example.basicmvi_hiltplayground.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.basicmvi_hiltplayground.R
import com.example.basicmvi_hiltplayground.model.Blog
import com.example.basicmvi_hiltplayground.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val TAG: String = "AppDebug"

    private val viewModel: MainViewModel by viewModels() //kts dependency

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        subscribeObservers()
        viewModel.setStateEvent(MainStateEvent.GetBlogEvents)
    }

    private fun subscribeObservers(){
        viewModel.dataState.observe(this, Observer{ dataState ->

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