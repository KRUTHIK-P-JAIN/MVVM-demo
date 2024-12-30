package com.example.mvvmdemo.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdemo.QuotesApplication
import com.example.mvvmdemo.R
import com.example.mvvmdemo.viewmodel.QuotesViewModel
import com.example.mvvmdemo.viewmodel.QuotesViewModelFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = (application as QuotesApplication).quoteRepository

        val quotesViewModel = ViewModelProvider(
            this,
            QuotesViewModelFactory(repository)
        )[QuotesViewModel::class.java]

        quotesViewModel.quotes.observe(this) {
            Toast.makeText(this@MainActivity, it.results.size.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}