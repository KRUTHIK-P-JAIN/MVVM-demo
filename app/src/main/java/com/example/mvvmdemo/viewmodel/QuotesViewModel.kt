package com.example.mvvmdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmdemo.model.Quote
import com.example.mvvmdemo.model.QuotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuotesViewModel(private val quotesRepository: QuotesRepository): ViewModel() {

    fun getQuotes(): LiveData<List<Quote>> {
        return quotesRepository.getQuotes()
    }

    fun insertQuotes(quote: Quote){
        viewModelScope.launch(Dispatchers.IO) {
            quotesRepository.insertQuotes(quote)
        }
    }
}