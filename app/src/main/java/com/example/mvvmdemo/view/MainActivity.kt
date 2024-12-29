package com.example.mvvmdemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.mvvmdemo.R
import com.example.mvvmdemo.databinding.ActivityMainBinding
import com.example.mvvmdemo.model.Quote
import com.example.mvvmdemo.model.QuotesDB
import com.example.mvvmdemo.model.QuotesRepository
import com.example.mvvmdemo.viewmodel.QuotesViewModel
import com.example.mvvmdemo.viewmodel.QuotesViewModelFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val dao = QuotesDB.getDatabase(applicationContext).quotesDao()
        val repository = QuotesRepository(dao)
        val viewModel = ViewModelProvider(this, QuotesViewModelFactory(repository)).get<QuotesViewModel>()

        viewModel.getQuotes().observe(this) {
            binding.quotes = it?.toString()
        }

        binding.btnAddQuote.setOnClickListener {
            viewModel.insertQuotes(Quote(0,"Testing Quote", "tester", 1))
        }
    }
}