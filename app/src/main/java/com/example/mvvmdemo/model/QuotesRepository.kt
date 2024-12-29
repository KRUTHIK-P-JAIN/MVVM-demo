package com.example.mvvmdemo.model

import androidx.lifecycle.LiveData

class QuotesRepository(private val quotesDao: QuotesDao) {

    fun getQuotes(): LiveData<List<Quote>>{
        return quotesDao.getQuotes()
    }

    suspend fun insertQuotes(quote: Quote){
        quotesDao.insertQuotes(quote)
    }
}