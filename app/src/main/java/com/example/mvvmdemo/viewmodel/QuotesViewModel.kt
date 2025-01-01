package com.example.mvvmdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmdemo.model.QuoteList
import com.example.mvvmdemo.model.QuotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuotesViewModel(private val quotesRepository: QuotesRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            quotesRepository.getQuotes(1)
        }
    }

    val quotes: LiveData<QuoteList>
        get() = quotesRepository.quotes
}